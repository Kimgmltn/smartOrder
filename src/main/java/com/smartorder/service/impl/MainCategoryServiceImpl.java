package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveMainCategoryRequest;
import com.smartorder.entity.Company;
import com.smartorder.entity.MainCategory;
import com.smartorder.repository.MainCategoryRepository;
import com.smartorder.service.MainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainCategoryServiceImpl implements MainCategoryService {

    private final MainCategoryRepository mainCategoryRepository;

    @Override
    public void saveMainCategory(SaveMainCategoryRequest request) {
        MainCategory mainCategory = MainCategory.builder()
                .company(new Company(request.getCompanyId()))
                .mainCategoryName(request.getMainCategoryName())
                .build();
        mainCategoryRepository.save(mainCategory);
    }
}
