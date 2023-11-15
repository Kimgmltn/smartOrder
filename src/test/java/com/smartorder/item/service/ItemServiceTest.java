package com.smartorder.item.service;

import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.controller.response.SaveCategoryResponse;
import com.smartorder.category.service.CategoryService;
import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.service.CompanyService;
import com.smartorder.item.controller.request.SaveItemRequest;
import com.smartorder.item.controller.response.SaveItemResponse;
import com.smartorder.item.entity.Item;
import com.smartorder.item.exception.ItemException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CompanyService companyService;

    @DisplayName("하나의 카테고리에 여러 메뉴를 등록 할 수 있다.")
    @Test
    void addItemList() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명"));
        categoryService.saveCategories(new SaveCategoryRequest(company.getCompanyId(), List.of("갈비", "식사", "음료")));
        Long categoryId = categoryService.findByCategoryNameAndCompanyId("갈비", company.getCompanyId()).getId();

        SaveItemRequest.SaveItem item1 = new SaveItemRequest.SaveItem("돼지갈비", 17000);
        SaveItemRequest.SaveItem item2 = new SaveItemRequest.SaveItem("소양념갈비", 19000);
        SaveItemRequest request = new SaveItemRequest(company.getCompanyId(), categoryId, List.of(item1, item2));

        //when
        SaveItemResponse response = itemService.saveItems(request);

        //then
        assertThat(response.getResult()).isEqualTo("메뉴 2개가 등록되었습니다.");
    }

    @DisplayName("카테고리Id와 메뉴명을 통해 메뉴를 찾을 수 있다.")
    @Test
    void findItemByCategoryIdAndItemName() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명"));
        categoryService.saveCategories(new SaveCategoryRequest(company.getCompanyId(), List.of("갈비", "식사", "음료")));
        Long categoryId = categoryService.findByCategoryNameAndCompanyId("갈비", company.getCompanyId()).getId();

        SaveItemRequest.SaveItem item1 = new SaveItemRequest.SaveItem("돼지갈비", 17000);
        SaveItemRequest.SaveItem item2 = new SaveItemRequest.SaveItem("소양념갈비", 19000);
        SaveItemRequest request = new SaveItemRequest(company.getCompanyId(), categoryId, List.of(item1, item2));
        itemService.saveItems(request);

        //when
        Item item = itemService.findByCategoryIdAndItemName(company.getCompanyId(), categoryId, "돼지갈비");

        //then
        assertThat(item.getItemName()).isEqualTo("돼지갈비");
        assertThat(item.getCategory().getId()).isEqualTo(categoryId);
    }

    @DisplayName("메뉴명이 해당 카테도리에 없는 경우 error를 뱉는다.")
    @Test
    void noItemNameToError() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명"));
        categoryService.saveCategories(new SaveCategoryRequest(company.getCompanyId(), List.of("갈비", "식사", "음료")));
        Long categoryId = categoryService.findByCategoryNameAndCompanyId("갈비", company.getCompanyId()).getId();

        SaveItemRequest.SaveItem item1 = new SaveItemRequest.SaveItem("돼지갈비", 17000);
        SaveItemRequest.SaveItem item2 = new SaveItemRequest.SaveItem("소양념갈비", 19000);
        SaveItemRequest request = new SaveItemRequest(company.getCompanyId(), categoryId, List.of(item1, item2));
        itemService.saveItems(request);

        //when
        //then
        assertThrows(ItemException.class, () -> itemService.findByCategoryIdAndItemName(company.getCompanyId(), categoryId, "된장찌게"));
    }

}