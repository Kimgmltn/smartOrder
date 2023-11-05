package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveMiddleCategoryRequest;
import com.smartorder.entity.MainCategory;
import com.smartorder.entity.MiddleCategory;
import com.smartorder.repository.MiddleCategoryRepository;
import com.smartorder.service.MiddleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MiddleCategoryServiceImpl implements MiddleCategoryService {

    private final MiddleCategoryRepository middleCategoryRepository;

    @Override
    public void saveMiddleCategory(SaveMiddleCategoryRequest request) {
        MiddleCategory middleCategory = MiddleCategory.builder()
                .mainCategory(new MainCategory(request.getMainCategoryId()))
                .middleCategoryName(request.getMiddleCategoryName())
                .build();
        middleCategoryRepository.save(middleCategory);
    }
}
