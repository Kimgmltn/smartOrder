package com.smartorder.orders.service;

import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.SaveOrdersResponse;

public interface OrdersService {

    SaveOrdersResponse saveOrder(SaveOrdersRequest saveOrdersRequest);
}
