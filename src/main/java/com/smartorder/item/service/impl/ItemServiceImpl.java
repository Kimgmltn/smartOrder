package com.smartorder.item.service.impl;

import com.smartorder.category.entity.Category;
import com.smartorder.category.service.CategoryService;
import com.smartorder.item.controller.request.SaveItemRequest;
import com.smartorder.item.controller.response.SaveItemResponse;
import com.smartorder.item.entity.Item;
import com.smartorder.item.repository.ItemRepository;
import com.smartorder.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    @Override
    public SaveItemResponse saveItems(SaveItemRequest request) {
        Category category = categoryService.findByIdAndCompanyId(request.getCategoryId(), request.getCompanyId());
        Long categoryId = category.getId();
        String text = "메뉴 {count}개가 등록되었습니다.";
        List<Item> items = request.getItems().stream().map(req -> Item.create(categoryId, req)).collect(Collectors.toList());
        List<Item> savedItems = itemRepository.saveAll(items);
        String replace = text.replace("{count}", String.valueOf(savedItems.size()));
        return new SaveItemResponse(replace);
    }
}
