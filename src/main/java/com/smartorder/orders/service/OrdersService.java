package com.smartorder.orders.service;

import com.smartorder.orders.controller.request.SaveOrdersRequest;
import com.smartorder.orders.controller.response.SaveOrdersResponse;

public interface OrdersService {

    SaveOrdersResponse saveOrder(SaveOrdersRequest saveOrdersRequest);
}
