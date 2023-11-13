package com.smartorder.restaurantTable.service;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.service.CompanyService;
import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.controller.response.SaveTablesResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestaurantTableServiceTest {

    @Autowired
    private RestaurantTableService restaurantTableService;
    @Autowired
    private CompanyService companyService;

    @DisplayName("여러개의 테이블을 한번에 등록할 수 있다.")
    @Test
    void test() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명주소"));
        SaveTablesRequest saveTableRequest = new SaveTablesRequest(company.getCompanyId(), List.of("1","2","3"));

        //when
        SaveTablesResponse response = restaurantTableService.saveTables(saveTableRequest);

        //then
        assertThat(response.getResult()).isEqualTo("테이블 3개가 등록되었습니다.");
    }
}