package com.smartorder.company.repository.querydsl;

import com.smartorder.company.entity.Company;

import java.util.List;

public interface CompanyQueryRepository {

    List<Company> findAllCompanies();
}
