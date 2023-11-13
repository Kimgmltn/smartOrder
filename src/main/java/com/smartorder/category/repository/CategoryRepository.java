package com.smartorder.category.repository;

import com.smartorder.category.entity.Category;
import com.smartorder.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryNameAndCompany(String categoryName, Long companyId);

    Optional<Category> findByCompany_IdAndId(Long companyId, Long categoryId);

}
