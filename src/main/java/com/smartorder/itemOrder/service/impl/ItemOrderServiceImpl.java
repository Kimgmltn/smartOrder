package com.smartorder.itemOrder.service.impl;

import com.smartorder.itemOrder.repository.ItemOrderRepository;
import com.smartorder.itemOrder.service.ItemOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemOrderServiceImpl implements ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;


}
