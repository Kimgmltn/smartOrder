package com.smartorder.orders.service.impl;

import com.smartorder.item.entity.Item;
import com.smartorder.item.service.ItemService;
import com.smartorder.orders.controller.request.SaveOrdersRequest;
import com.smartorder.orders.controller.response.SaveOrdersResponse;
import com.smartorder.orders.entity.Orders;
import com.smartorder.orders.repository.OrdersRepository;
import com.smartorder.orders.service.OrdersService;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final RestaurantTableService tableService;
    private final ItemService itemService;

    @Override
    public SaveOrdersResponse saveOrder(SaveOrdersRequest request) {
        Long companyId = request.getCompanyId();
        List<SaveOrdersRequest.ItemOrderRequest> itemOrderRequests = request.getItemOrderRequests();
        List<Long> itemIds = itemOrderRequests.stream().map(req -> req.getItemId()).collect(Collectors.toList());

        // map으로 변환



        RestaurantTable table = tableService.findByCompanyIdAndTableId(companyId, request.getTableId());
        List<Item> items = itemService.findByCompanyIdAndItemIds(companyId, itemIds);
//        items.stream().map(item -> Orders.creaet());
        return null;
    }
}
