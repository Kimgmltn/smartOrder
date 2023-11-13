package com.smartorder.category.service.impl;

import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.controller.response.SaveCategoryResponse;
import com.smartorder.category.entity.Category;
import com.smartorder.category.exception.CategoryException;
import com.smartorder.category.repository.CategoryRepository;
import com.smartorder.category.service.CategoryService;
import com.smartorder.company.entity.Company;
import com.smartorder.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CompanyService companyService;

    @Override
    @Transactional
    public SaveCategoryResponse saveCategories(SaveCategoryRequest request) {
        Company company = companyService.findById(request.getCompanyId());
        Long companyId = company.getId();
        String text = "메뉴 {count}개가 등록되었습니다.";
        List<Category> categories = request.getCategoryNames().stream().map(name -> Category.create(companyId, name)).collect(Collectors.toList());
        List<Category> savedCategories = categoryRepository.saveAll(categories);
        String replace = text.replace("{count}", String.valueOf(savedCategories.size()));
        return new SaveCategoryResponse(replace);
    }

    @Override
    public Category findByCategoryIdAndCompanyId(Long categoryId, Long companyId) {
//        Company company = companyService.findById(companyId);
        Optional<Category> category = categoryRepository.findByCompany_IdAndId(companyId, categoryId);
        if (!category.isPresent()) {
            throw new CategoryException("해당 회사에 등록된 카테고리가 없습니다.");
        }
        return category.get();
    }

    @Override
    public Category findByCategoryNameAndCompanyId(String categoryName, Long companyId) {
        Optional<Category> category = categoryRepository.findByCategoryNameAndCompany(categoryName, companyId);
        if (!category.isPresent()) {
            throw new CategoryException("해당 회사에 등록된 카테고리가 없습니다.");
        }
        return category.get();
    }
}
