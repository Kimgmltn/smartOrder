package com.smartorder.service;

import com.smartorder.dto.request.SaveItemRequest;
import com.smartorder.entity.Item;

public interface ItemService {
    void saveItem(SaveItemRequest request);

    Item findById(Long ItemId);
}
