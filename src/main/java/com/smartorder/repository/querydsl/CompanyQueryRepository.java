package com.smartorder.repository.querydsl;

import com.smartorder.entity.Company;

import java.util.List;

public interface CompanyQueryRepository {

    List<Company> findAllCompanies();
}
