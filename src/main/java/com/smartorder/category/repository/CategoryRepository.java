package com.smartorder.category.repository;

import com.smartorder.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryNameAndCompany_Id(String categoryName, Long companyId);

    Optional<Category> findByIdAndCompany_Id(Long categoryId, Long companyId);

}
