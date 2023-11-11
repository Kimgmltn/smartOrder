package com.smartorder.company.repository.querydsl.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartorder.company.entity.Company;
import com.smartorder.company.repository.querydsl.CompanyQueryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanyQueryRepositoryImpl implements CompanyQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Company> findAllCompanies() {
//        QCompany company = QCompany.company;
//        List<Company> companies = query.selectFrom(company).fetch();
//        return companies;
        return null;
    }
}
