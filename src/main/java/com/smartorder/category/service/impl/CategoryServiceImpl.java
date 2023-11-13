package com.smartorder.category.service.impl;

import com.smartorder.category.controller.request.SaveCategoryRequest;
import com.smartorder.category.controller.response.SaveCategoryResponse;
import com.smartorder.category.entity.Category;
import com.smartorder.category.repository.CategoryRepository;
import com.smartorder.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public SaveCategoryResponse saveCategories(SaveCategoryRequest request) {
        Long companyId = request.getCompanyId();
        String text = "메뉴 {count}개가 등록되었습니다.";
        List<Category> categories = request.getCategoryNames().stream().map(name -> Category.create(companyId, name)).collect(Collectors.toList());
        List<Category> savedCategories = categoryRepository.saveAll(categories);
        String replace = text.replace("{count}", String.valueOf(savedCategories.size()));
        return new SaveCategoryResponse(replace);
    }
}
