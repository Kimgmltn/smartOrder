package com.smartorder.repository;

import com.smartorder.entity.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("회사 save")
    void save(){
        Company company = Company.builder()
                .companyName("갈비대첩")
                .build();
        Company save = companyRepository.save(company);
        Company find  = companyRepository.findByCompanyName("갈비대첩").get();
        Assertions.assertThat(find.getCompanyName()).isEqualTo(save.getCompanyName());
    }

    @Test
    @DisplayName("회사명 변경")
    void update_save(){
        Company company = Company.builder()
                .companyName("갈비대첩")
                .build();
        companyRepository.save(company);

        Company find  = companyRepository.findByCompanyName("갈비대첩").get();
        find.changeCompanyName("갈비대첩2");
        companyRepository.save(find);

        Company find2 = companyRepository.findByCompanyName("갈비대첩2").get();
        Assertions.assertThat(find.getCompanyId()).isEqualTo(find2.getCompanyId());
    }

}