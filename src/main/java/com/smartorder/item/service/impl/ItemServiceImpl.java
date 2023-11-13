package com.smartorder.item.service.impl;

import com.smartorder.item.controller.request.SaveItemRequest;
import com.smartorder.item.controller.response.SaveItemResponse;
import com.smartorder.item.repository.ItemRepository;
import com.smartorder.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public SaveItemResponse saveItems(SaveItemRequest request) {
        return null;
    }
}
