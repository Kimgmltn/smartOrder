package com.smartorder.repository.querydsl;

import com.smartorder.entity.Company;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public interface CompanySearch {

    List<Company> findAllCompanys();
}
