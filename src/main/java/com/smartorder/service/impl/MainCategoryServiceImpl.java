package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveMainCategoryRequest;
import com.smartorder.entity.Company;
import com.smartorder.entity.MainCategory;
import com.smartorder.exception.MainCategoryException;
import com.smartorder.repository.MainCategoryRepository;
import com.smartorder.service.CompanyService;
import com.smartorder.service.MainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainCategoryServiceImpl implements MainCategoryService {

    private final MainCategoryRepository mainCategoryRepository;
    private final CompanyService companyService;

    @Override
    public void saveMainCategory(SaveMainCategoryRequest request) {
        Company company = companyService.findById(request.getCompanyId());
        MainCategory mainCategory = MainCategory.builder()
                .company(company)
                .mainCategoryName(request.getMainCategoryName())
                .build();
        mainCategoryRepository.save(mainCategory);
    }

    @Override
    public MainCategory findById(Long mainCategoryId) {
        return mainCategoryRepository.findById(mainCategoryId).orElseThrow(() -> new MainCategoryException("해당하는 대분류가 없습니다."));
    }
}
