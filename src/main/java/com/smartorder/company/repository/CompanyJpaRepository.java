package com.smartorder.company.repository;

import com.smartorder.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyJpaRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(String companyName);
}
