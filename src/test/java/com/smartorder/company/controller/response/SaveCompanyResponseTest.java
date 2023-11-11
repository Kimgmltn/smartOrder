package com.smartorder.company.controller.response;

import com.smartorder.company.entity.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SaveCompanyResponseTest {

    @DisplayName("Company 객체를 SaveCompanyResponse객체로 변환할 수 있다.")
    @Test
    void test() {
        //given
        Company company = Company.builder().id(1L).companyName("갈비").roadNameAddress("도로명").build();
        //when
        SaveCompanyResponse saveCompanyResponse = SaveCompanyResponse.fromEntityToResponse(company);

        //then
        assertThat(saveCompanyResponse.getCompanyId()).isEqualTo(company.getId());
        assertThat(saveCompanyResponse.getCompanyName()).isEqualTo(company.getCompanyName());
        assertThat(saveCompanyResponse.getRoadNameAddress()).isEqualTo(company.getRoadNameAddress());
    }

}