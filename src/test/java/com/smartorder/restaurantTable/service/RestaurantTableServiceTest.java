package com.smartorder.restaurantTable.service;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.service.CompanyService;
import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.controller.response.SaveTablesResponse;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.exception.RestaurantTableException;
import org.junit.jupiter.api.Assertions;
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

    @DisplayName("회사ID와 테이블번호를 가지고 해당 테이블을 찾을 수 있다.")
    @Test
    void findByCompanyIdAndTableNo() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명주소"));
        SaveTablesRequest saveTableRequest = new SaveTablesRequest(company.getCompanyId(), List.of("1","2","3"));
        restaurantTableService.saveTables(saveTableRequest);

        //when
        RestaurantTable response = restaurantTableService.findByCompanyIdAndTableNo(company.getCompanyId(), "1");

        //then
        assertThat(response).isNotNull();
    }

    @DisplayName("회사에 해당 테이블번호가 없으면 Error가 발생한다.")
    @Test
    void exceptionByNoTableNo() {
        //given
        SaveCompanyResponse company = companyService.saveCompany(new SaveCompanyRequest("갈비", "도로명주소"));
        SaveTablesRequest saveTableRequest = new SaveTablesRequest(company.getCompanyId(), List.of("1","2","3"));
        restaurantTableService.saveTables(saveTableRequest);

        //when
        //then
        Assertions.assertThrows(RestaurantTableException.class, () -> restaurantTableService.findByCompanyIdAndTableNo(company.getCompanyId(), "11"));
    }


}