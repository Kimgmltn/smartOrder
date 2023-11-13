package com.smartorder.category.service;

import com.smartorder.category.entity.Category;
import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.service.CompanyService;
import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.controller.response.SaveCategoryResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CompanyService companyService;

    @DisplayName("대분류를 등록 할 수 있다.")
    @Test
    void addCategories() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명주소"));
        SaveCategoryRequest request = new SaveCategoryRequest(company.getCompanyId(), List.of("돼지갈비", "소갈비", "양갈비"));

        //when
        SaveCategoryResponse response = categoryService.saveCategories(request);

        //then
        assertThat(response.getResult()).isEqualTo("메뉴 3개가 등록되었습니다.");
    }

    // TODO Repository에서 에러남.
    @DisplayName("회사ID와 카테고리ID로 특정 카테고리를 검색 할 수 있다.")
    @Test
    void findCategoryByCategoryIdAndCompanyId() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명주소"));
        SaveCategoryRequest request = new SaveCategoryRequest(company.getCompanyId(), List.of("돼지갈비", "소갈비", "양갈비"));
        categoryService.saveCategories(request);

        //when
        Category category = categoryService.findByCategoryIdAndCompanyId(1L, company.getCompanyId());

        //then
        assertThat(category).isNotNull();
    }



    @DisplayName("회사ID와 카테고리명으로 특정 카테고리를 검색 할 수 있다.")
    @Test
    void findCategoryByCategoryNameAndCompanyId() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명주소"));
        SaveCategoryRequest request = new SaveCategoryRequest(company.getCompanyId(), List.of("돼지갈비", "소갈비", "양갈비"));
//        SaveCategoryResponse saveCategoryResponse = categoryService.saveCategories(request);

        //when
//        categoryService.findByCategoryNameAndCompanyId(saveCategoryResponse, company.getCompanyId())

        //then
    }

}