package com.smartorder.repository.querydsl.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartorder.entity.Company;
import com.smartorder.entity.QCompany;
import com.smartorder.repository.querydsl.CompanyQueryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanyQueryRepositoryImpl implements CompanyQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Company> findAllCompanies() {
        QCompany company = QCompany.company;
        List<Company> companies = query.selectFrom(company).fetch();
        return companies;
    }
}
