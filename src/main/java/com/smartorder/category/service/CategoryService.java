package com.smartorder.category.service;

import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.controller.response.SaveCategoryResponse;
import com.smartorder.category.entity.Category;

public interface CategoryService {

    SaveCategoryResponse saveCategories(SaveCategoryRequest request);

    Category findByCategoryNameAndCompanyId(String categoryName, Long companyId);

    Category findByIdAndCompanyId(Long categoryId, Long companyId);
}
