package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveItemRequest;
import com.smartorder.entity.Item;
import com.smartorder.entity.MiddleCategory;
import com.smartorder.exception.ItemException;
import com.smartorder.repository.ItemRepository;
import com.smartorder.service.ItemService;
import com.smartorder.service.MiddleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final MiddleCategoryService middleCategoryService;

    @Override
    public void saveItem(SaveItemRequest request) {
        MiddleCategory middleCategory = middleCategoryService.findById(request.getMiddleCategoryId());
        Item item = Item.builder()
                .itemName(request.getItemName())
                .middleCategory(middleCategory)
                .price(request.getPrice())
                .build();
        itemRepository.save(item);
    }

    @Override
    public Item findById(Long ItemId) {
        return itemRepository.findById(ItemId).orElseThrow(()-> new ItemException("해당 메뉴가 없습니다."));
    }
}
