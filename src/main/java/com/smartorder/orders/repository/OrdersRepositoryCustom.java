package com.smartorder.orders.repository;

import com.smartorder.orders.dto.response.OrderListResponse;

public interface OrdersRepositoryCustom {

    OrderListResponse findUseOrderListByOrderId(Long orderId);
}
