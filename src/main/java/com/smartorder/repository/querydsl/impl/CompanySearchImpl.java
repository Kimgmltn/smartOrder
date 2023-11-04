package com.smartorder.repository.querydsl.impl;

import com.smartorder.entity.Company;
import com.smartorder.repository.querydsl.CompanySearch;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CompanySearchImpl extends QuerydslRepositorySupport implements CompanySearch {

    public CompanySearchImpl() {
        super(Company.class);
    }

    @Override
    public List<Company> findAllCompanys() {
//        QCompany.company;
        return null;
    }
}
