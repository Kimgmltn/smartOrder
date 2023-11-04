package com.smartorder.repository;

import com.smartorder.entity.Company;
import com.smartorder.repository.querydsl.CompanySearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long>, CompanySearch {

    Optional<Company> findByCompanyName(String companyName);
}
