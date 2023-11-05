package com.smartorder.service;

import com.smartorder.dto.request.SaveMiddleCategoryRequest;
import com.smartorder.entity.MiddleCategory;

public interface MiddleCategoryService {
    void saveMiddleCategory(SaveMiddleCategoryRequest request);

    MiddleCategory findById(Long middleCategoryId);
}
