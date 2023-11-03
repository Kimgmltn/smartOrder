package com.smartorder.repository;

import com.smartorder.entity.Company;
import com.smartorder.entity.RestaurantTable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Slf4j
@Transactional
class RestaurantTableRepositoryTest {

    @Autowired
    private RestaurantTableRepository repository;
    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    void init(){
        Company company = Company.builder().companyName("갈비대첩").roadNameAddress("안양").build();
        companyRepository.save(company);
        log.info("companyId : {}", company.getCompanyId());
        log.info("companyName : {}", company.getCompanyName());
        log.info("crete date : {}", company.getCreatedDate());
    }

    @Test
    @DisplayName("테이블 등록")
    @Rollback
    void save(){
        Company company = companyRepository.findByCompanyName("갈비대첩").get();
        RestaurantTable table = RestaurantTable.builder()
                .tableNo("1")
                .company(company)
                .build();

        repository.save(table);
        RestaurantTable find = repository.findAll().get(0);
        log.info("table_id : {}", find.getTableId());
        log.info("company_id : {}", find.getCompany().getCompanyId());
        assertThat(find.getTableId()).isEqualTo(table.getTableId());
        assertThat(find.getCompany().getCompanyName()).isEqualTo("갈비대첩");
        assertThat(find.getTableNo()).isEqualTo("1");
    }

}