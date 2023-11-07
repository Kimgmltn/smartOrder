package com.smartorder.service.impl;

import com.smartorder.repository.OrdersRepository;
import com.smartorder.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;


}
