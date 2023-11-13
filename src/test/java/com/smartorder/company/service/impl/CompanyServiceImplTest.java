package com.smartorder.company.service.impl;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.request.UpdateCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.controller.response.UpdateCompanyResponse;
import com.smartorder.company.entity.Company;
import com.smartorder.company.exception.CompanyException;
import com.smartorder.company.repository.CompanyJpaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyServiceImplTest {

    @Autowired
    private CompanyServiceImpl companyService;

    @DisplayName("SaveCompanyRequest를 통해 회사를 등록할 수 있다.")
    @Test
    void saveCompany() {
        //given
        SaveCompanyRequest saveCompanyRequest = new SaveCompanyRequest("갈비", "도로명 주소");

        //when
        SaveCompanyResponse response = companyService.saveCompany(saveCompanyRequest);

        //then
        assertThat(response.getCompanyId()).isNotNull();
        assertThat(response.getCompanyName()).isEqualTo(saveCompanyRequest.getCompanyName());
        assertThat(response.getRoadNameAddress()).isEqualTo(saveCompanyRequest.getRoadNameAddress());
    }

    @DisplayName("회사명만 변경 가능하다.")
    @Test
    void updateCompanyInfoOnlyCompanyName() {
        //given
        SaveCompanyRequest saveCompanyRequest = new SaveCompanyRequest("갈비", "도로명 주소");
        SaveCompanyResponse savedCompany = companyService.saveCompany(saveCompanyRequest);
        UpdateCompanyRequest updateRequest = new UpdateCompanyRequest(savedCompany.getCompanyId(), "갈비2", "도로명 주소");

        //when
        UpdateCompanyResponse updateCompanyResponse = companyService.updateCompany(updateRequest);

        //then
        assertThat(updateCompanyResponse.getCompanyId()).isEqualTo(savedCompany.getCompanyId());
        assertThat(updateCompanyResponse.getCompanyName()).isEqualTo(updateRequest.getCompanyName());
        assertThat(updateCompanyResponse.getRoadNameAddress()).isEqualTo(savedCompany.getRoadNameAddress());
    }

    @DisplayName("도로명 주소만 변경 가능하다.")
    @Test
    void updateCompanyInfoOnlyRoadNameAddress() {
        //given
        SaveCompanyRequest saveCompanyRequest = new SaveCompanyRequest("갈비", "도로명 주소");
        SaveCompanyResponse savedCompany = companyService.saveCompany(saveCompanyRequest);
        UpdateCompanyRequest updateRequest = new UpdateCompanyRequest(savedCompany.getCompanyId(), "갈비", "도로명 주소2");

        //when
        UpdateCompanyResponse updateCompanyResponse = companyService.updateCompany(updateRequest);

        //then
        assertThat(updateCompanyResponse.getCompanyId()).isEqualTo(savedCompany.getCompanyId());
        assertThat(updateCompanyResponse.getCompanyName()).isEqualTo(savedCompany.getCompanyName());
        assertThat(updateCompanyResponse.getRoadNameAddress()).isEqualTo(updateRequest.getRoadNameAddress());
    }

    @DisplayName("회사명, 도로명 주소 한번에 변경 가능하다")
    @Test
    void updateCompanyInfoCompanyNameAndRoadNameAddress() {
        //given
        SaveCompanyRequest saveCompanyRequest = new SaveCompanyRequest("갈비", "도로명 주소");
        SaveCompanyResponse savedCompany = companyService.saveCompany(saveCompanyRequest);
        UpdateCompanyRequest updateRequest = new UpdateCompanyRequest(savedCompany.getCompanyId(), "갈비2", "도로명 주소2");

        //when
        UpdateCompanyResponse updateCompanyResponse = companyService.updateCompany(updateRequest);

        //then
        assertThat(updateCompanyResponse.getCompanyId()).isEqualTo(savedCompany.getCompanyId());
        assertThat(updateCompanyResponse.getCompanyName()).isEqualTo(updateRequest.getCompanyName());
        assertThat(updateCompanyResponse.getRoadNameAddress()).isEqualTo(updateRequest.getRoadNameAddress());
    }

    @DisplayName("존재하지 않는 companyId일 경우 CompanyException으로 던진다.")
    @Test
    void test() {
        //given
        Long companyId = 2L;

        //when
        //then
        assertThrows(CompanyException.class, () -> companyService.findById(companyId));
    }
}