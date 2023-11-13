package com.smartorder.category.service;

import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.controller.response.SaveCategoryResponse;

public interface CategoryService {

    SaveCategoryResponse saveCategories(SaveCategoryRequest request);
}
