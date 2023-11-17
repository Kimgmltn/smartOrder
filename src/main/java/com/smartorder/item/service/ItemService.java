package com.smartorder.item.service;

import com.smartorder.item.dto.request.SaveItemRequest;
import com.smartorder.item.dto.response.SaveItemResponse;
import com.smartorder.item.entity.Item;

import java.util.List;

public interface ItemService {
    SaveItemResponse saveItems(SaveItemRequest request);

    Item findByCategoryIdAndItemName(Long companyId, Long categoryId, String itemName);

    List<Item> findByCompanyIdAndItemIds(Long companyId, List<Long> itemIds);
}
