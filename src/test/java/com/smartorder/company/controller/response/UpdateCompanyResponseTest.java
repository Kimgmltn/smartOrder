package com.smartorder.company.controller.response;

import com.smartorder.company.dto.response.UpdateCompanyResponse;
import com.smartorder.company.entity.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateCompanyResponseTest {

    @DisplayName("Company 객체로부터 UpdateCompanyResponse 객체로 변환 할 수 있다.")
    @Test
    void test() {
        //given
        Company company = Company.builder().id(1L).companyName("갈비").roadNameAddress("도로명").build();
        //when
        UpdateCompanyResponse updateCompanyResponse = UpdateCompanyResponse.fromEntityToResponse(company);

        //then
        assertThat(updateCompanyResponse.getCompanyId()).isEqualTo(company.getId());
        assertThat(updateCompanyResponse.getCompanyName()).isEqualTo(company.getCompanyName());
        assertThat(updateCompanyResponse.getRoadNameAddress()).isEqualTo(company.getRoadNameAddress());
    }

}