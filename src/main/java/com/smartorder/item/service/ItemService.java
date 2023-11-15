package com.smartorder.item.service;

import com.smartorder.item.controller.request.SaveItemRequest;
import com.smartorder.item.controller.response.SaveItemResponse;
import com.smartorder.item.entity.Item;

public interface ItemService {
    SaveItemResponse saveItems(SaveItemRequest request);

    Item findByCategoryIdAndItemName(Long companyId, Long categoryId, String itemName);
}
