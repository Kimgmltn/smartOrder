package com.smartorder.company.entity;

import com.smartorder.company.dto.request.SaveCompanyRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CompanyTest {

    @DisplayName("SaveCompanyRequest를 통해서 company를 만들 수 있다.")
    @Test
    void createCompany() {
        //given
        SaveCompanyRequest saveCompanyRequest = new SaveCompanyRequest("갈비", "도로명 주소");

        //when
        Company company = Company.createCompany(saveCompanyRequest);

        //then
        assertThat(company.getCompanyName()).isEqualTo(saveCompanyRequest.getCompanyName());
        assertThat(company.getRoadNameAddress()).isEqualTo(saveCompanyRequest.getRoadNameAddress());
    }
}