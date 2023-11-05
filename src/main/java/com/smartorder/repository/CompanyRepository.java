package com.smartorder.repository;

import com.smartorder.entity.Company;
import com.smartorder.repository.querydsl.CompanyQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyQueryRepository {

    Optional<Company> findByCompanyName(String companyName);
}
