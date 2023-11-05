package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveItemRequest;
import com.smartorder.entity.Item;
import com.smartorder.entity.MiddleCategory;
import com.smartorder.repository.ItemRepository;
import com.smartorder.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public void saveItem(SaveItemRequest request) {
        Item item = Item.builder()
                .itemName(request.getItemName())
                .middleCategory(new MiddleCategory(request.getMiddleCategoryId()))
                .price(request.getPrice())
                .build();
        itemRepository.save(item);
    }
}
