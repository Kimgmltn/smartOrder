package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveMiddleCategoryRequest;
import com.smartorder.entity.MainCategory;
import com.smartorder.entity.MiddleCategory;
import com.smartorder.exception.MiddleCategoryException;
import com.smartorder.repository.MiddleCategoryRepository;
import com.smartorder.service.MainCategoryService;
import com.smartorder.service.MiddleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MiddleCategoryServiceImpl implements MiddleCategoryService {

    private final MiddleCategoryRepository middleCategoryRepository;
    private final MainCategoryService mainCategoryService;

    @Override
    public void saveMiddleCategory(SaveMiddleCategoryRequest request) {
        MainCategory mainCategory = mainCategoryService.findById(request.getMainCategoryId());
        MiddleCategory middleCategory = MiddleCategory.builder()
                .mainCategory(mainCategory)
                .middleCategoryName(request.getMiddleCategoryName())
                .build();
        middleCategoryRepository.save(middleCategory);
    }

    @Override
    public MiddleCategory findById(Long middleCategoryId) {
        return middleCategoryRepository.findById(middleCategoryId).orElseThrow(() -> new MiddleCategoryException("해당하는 중분류가 없습니다."));
    }
}
