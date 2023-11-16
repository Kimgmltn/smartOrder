package com.smartorder.orders.service.impl;

import com.smartorder.orders.controller.request.SaveOrdersRequest;
import com.smartorder.orders.controller.response.SaveOrdersResponse;
import com.smartorder.orders.repository.OrdersRepository;
import com.smartorder.orders.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public SaveOrdersResponse saveOrder(SaveOrdersRequest saveOrdersRequest) {
        return null;
    }
}
