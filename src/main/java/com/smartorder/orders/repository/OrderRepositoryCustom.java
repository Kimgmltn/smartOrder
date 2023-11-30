package com.smartorder.orders.repository;

import com.smartorder.orders.dto.response.OrderListResponse;

import java.util.List;

public interface OrderRepositoryCustom {

    List<OrderListResponse> findOrderList();
}
