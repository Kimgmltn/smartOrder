package com.smartorder.itemOrder.repository;

import com.smartorder.orders.dto.response.ItemOrderResponse;

import java.util.List;

public interface ItemOrderRepositoryCustom {

    List<ItemOrderResponse> findUseItemOrderListByOrderId(Long orderId);
}
