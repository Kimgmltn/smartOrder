package com.smartorder.item.service;

import com.smartorder.item.controller.request.SaveItemRequest;
import com.smartorder.item.controller.response.SaveItemResponse;

public interface ItemService {
    SaveItemResponse saveItems(SaveItemRequest request);
}
