package com.smartorder.orders.service;

import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.service.CategoryService;
import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.service.CompanyService;
import com.smartorder.item.controller.request.SaveItemRequest;
import com.smartorder.item.entity.Item;
import com.smartorder.item.service.ItemService;
import com.smartorder.orders.controller.request.SaveOrdersRequest;
import com.smartorder.orders.controller.response.SaveOrdersResponse;
import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class OrdersServiceTest {

    @Autowired
    OrdersService ordersService;
    @Autowired
    CompanyService companyService;
    @Autowired
    RestaurantTableService restaurantTableService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ItemService itemService;

    @DisplayName("주문 하나에 여러개의 메뉴를 넣을 수 있다.")
    @Test
    void createOrder(){
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명"));
        restaurantTableService.saveTables(new SaveTablesRequest(company.getCompanyId(), List.of("1", "2")));
        RestaurantTable restaurantTable = restaurantTableService.findByCompanyIdAndTableNo(company.getCompanyId(), "1");
        categoryService.saveCategories(new SaveCategoryRequest(company.getCompanyId(), List.of("갈비", "식사", "음료")));
        Long categoryId = categoryService.findByCategoryNameAndCompanyId("갈비", company.getCompanyId()).getId();

        SaveItemRequest.SaveItem item1 = new SaveItemRequest.SaveItem("돼지갈비", 17000);
        SaveItemRequest.SaveItem item2 = new SaveItemRequest.SaveItem("소양념갈비", 19000);
        SaveItemRequest request = new SaveItemRequest(company.getCompanyId(), categoryId, List.of(item1, item2));
        itemService.saveItems(request);

        Item findItem1 = itemService.findByCategoryIdAndItemName(company.getCompanyId(), categoryId, "돼지갈비");
        Item findItem2 = itemService.findByCategoryIdAndItemName(company.getCompanyId(), categoryId, "소양념갈비");

        SaveOrdersRequest.ItemOrderRequest itemOrder1 = new SaveOrdersRequest.ItemOrderRequest(findItem1.getId(), 2);
        SaveOrdersRequest.ItemOrderRequest itemOrder2 = new SaveOrdersRequest.ItemOrderRequest(findItem2.getId(), 4);
        SaveOrdersRequest saveOrdersRequest = new SaveOrdersRequest(1L, List.of(itemOrder1, itemOrder2));

        //when
        SaveOrdersResponse saveOrdersResponse = ordersService.saveOrder(saveOrdersRequest);

        //then
        assertThat(saveOrdersResponse).isNotNull();
    }
}