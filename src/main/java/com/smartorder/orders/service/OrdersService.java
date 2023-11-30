package com.smartorder.orders.service;

import com.smartorder.orders.dto.request.AddOrdersRequest;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.OrderListResponse;

public interface OrdersService {

    OrderListResponse saveOrder(Long companyId, Long tableId, SaveOrdersRequest saveOrdersRequest);

    OrderListResponse addOrder(Long companyId, Long tableId, Long orderId, AddOrdersRequest addOrdersRequest);

    OrderListResponse findUseOrderList(Long orderId);
}
