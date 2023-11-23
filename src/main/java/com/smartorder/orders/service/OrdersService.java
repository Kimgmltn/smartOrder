package com.smartorder.orders.service;

import com.smartorder.orders.dto.request.AddOrdersRequest;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.AddOrdersResponse;
import com.smartorder.orders.dto.response.SaveOrdersResponse;

public interface OrdersService {

    SaveOrdersResponse saveOrder(Long companyId, Long tableId, SaveOrdersRequest saveOrdersRequest);

    AddOrdersResponse addOrder(Long companyId, Long tableId, Long orderId, AddOrdersRequest addOrdersRequest);
}
