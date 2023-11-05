package com.smartorder.service;

import com.smartorder.dto.request.SaveMainCategoryRequest;
import com.smartorder.entity.MainCategory;

public interface MainCategoryService {

    void saveMainCategory(SaveMainCategoryRequest request);

    MainCategory findById(Long mainCategoryId);

}
