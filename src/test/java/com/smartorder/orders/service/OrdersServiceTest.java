package com.smartorder.orders.service;

import com.smartorder.category.dto.request.SaveCategoryRequest;
import com.smartorder.category.entity.Category;
import com.smartorder.category.service.CategoryService;
import com.smartorder.company.dto.request.SaveCompanyRequest;
import com.smartorder.company.dto.response.SaveCompanyResponse;
import com.smartorder.company.service.CompanyService;
import com.smartorder.item.dto.request.SaveItemRequest;
import com.smartorder.item.entity.Item;
import com.smartorder.item.service.ItemService;
import com.smartorder.itemOrder.repository.ItemOrderRepository;
import com.smartorder.orders.dto.request.AddOrdersRequest;
import com.smartorder.orders.dto.request.ItemOrderRequest;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.ItemOrderResponse;
import com.smartorder.orders.dto.response.OrderListResponse;
import com.smartorder.orders.repository.OrdersRepository;
import com.smartorder.orders.service.impl.OrderServiceImpl;
import com.smartorder.restaurantTable.dto.request.SaveTablesRequest;
import com.smartorder.restaurantTable.dto.response.SaveTablesResponse;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OrdersServiceTest {

    OrdersService ordersService;
    @Mock
    OrdersRepository ordersRepository;
    @Mock
    ItemOrderRepository itemOrderRepository;
    @Mock
    CompanyService companyService;
    @Mock
    RestaurantTableService restaurantTableService;
    @Mock
    CategoryService categoryService;
    @Mock
    ItemService itemService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        ordersService = new OrderServiceImpl(ordersRepository, restaurantTableService, itemService, itemOrderRepository);
    }

    @DisplayName("주문 하나에 여러개의 메뉴를 넣을 수 있다.")
    @Test
    void createOrder(){
        //given
        Mockito.when(restaurantTableService.findByCompanyIdAndTableNo(1L, "1")).thenReturn(new RestaurantTable(1L));
//        Mockito.when(restaurantTableService.findByCompanyIdAndTableId(1L, 1L)).then(new RestaurantTable());
        Mockito.when(categoryService.findByCategoryNameAndCompanyId("갈비", 1L)).thenReturn(new Category(1L));
        Mockito.when(itemService.findByCategoryIdAndItemName(1L, 1L, "돼지갈비")).thenReturn(new Item(1L));
        Mockito.when(itemService.findByCategoryIdAndItemName(1L, 1L, "소양념갈비")).thenReturn(new Item(2L));


//        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명"));
//        restaurantTableService.saveTables(new SaveTablesRequest(company.getCompanyId(), List.of("1", "2")));
        RestaurantTable restaurantTable = restaurantTableService.findByCompanyIdAndTableNo(1L, "1");
//        categoryService.saveCategories(new SaveCategoryRequest(company.getCompanyId(), List.of("갈비", "식사", "음료")));
        Long categoryId = categoryService.findByCategoryNameAndCompanyId("갈비", 1L).getId();

//        SaveItemRequest.SaveItem item1 = new SaveItemRequest.SaveItem("돼지갈비", 17000);
//        SaveItemRequest.SaveItem item2 = new SaveItemRequest.SaveItem("소양념갈비", 19000);
//        SaveItemRequest request = new SaveItemRequest(1L, categoryId, List.of(item1, item2));
//        itemService.saveItems(request);

        Item findItem1 = itemService.findByCategoryIdAndItemName(1L, categoryId, "돼지갈비");
        Item findItem2 = itemService.findByCategoryIdAndItemName(1L, categoryId, "소양념갈비");

        ItemOrderRequest itemOrder1 = new ItemOrderRequest(findItem1.getId(), 2);
        ItemOrderRequest itemOrder2 = new ItemOrderRequest(findItem2.getId(), 4);
        SaveOrdersRequest saveOrdersRequest = new SaveOrdersRequest(List.of(itemOrder1, itemOrder2));

        //when
        OrderListResponse saveOrdersResponse = ordersService.saveOrder(1L, restaurantTable.getId(), saveOrdersRequest);

        //then
        assertThat(saveOrdersResponse).isNotNull();
        assertThat(saveOrdersResponse.getTotalPrice()).isEqualTo((17000*2) + (19000*4));
        assertThat(saveOrdersResponse.getItems().size()).isEqualTo(2);
    }

    @DisplayName("추가 주문시, orderSeq값이 증가한다.")
    @Test
    void addOrderToIncreaseOrderSeq(){
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

        ItemOrderRequest itemOrder1 = new ItemOrderRequest(findItem1.getId(), 2);
        ItemOrderRequest itemOrder2 = new ItemOrderRequest(findItem2.getId(), 4);
        SaveOrdersRequest saveOrdersRequest = new SaveOrdersRequest(List.of(itemOrder1, itemOrder2));
        OrderListResponse saveOrdersResponse = ordersService.saveOrder(company.getCompanyId(), restaurantTable.getId(), saveOrdersRequest);


        ItemOrderRequest itemOrder3 = new ItemOrderRequest(findItem1.getId(), 5);
        AddOrdersRequest addOrdersRequest = new AddOrdersRequest(saveOrdersResponse.getOrderId(), List.of(itemOrder3));

        //when
        OrderListResponse addOrderResponses = ordersService.addOrder(company.getCompanyId(), restaurantTable.getId(), saveOrdersResponse.getOrderId(), addOrdersRequest);

        //then
        assertThat(addOrderResponses).isNotNull();
        assertThat(addOrderResponses.getItems().size()).isEqualTo(3);
        assertThat(addOrderResponses.getItems().stream().map(ItemOrderResponse::getOrderSeq).max(Integer::compare).get()).isEqualTo(2);
    }

}