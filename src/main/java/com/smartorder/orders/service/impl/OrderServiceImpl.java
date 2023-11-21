package com.smartorder.orders.service.impl;

import com.smartorder.item.entity.Item;
import com.smartorder.item.service.ItemService;
import com.smartorder.itemOrder.entity.ItemOrder;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.SaveOrdersResponse;
import com.smartorder.orders.entity.Orders;
import com.smartorder.orders.repository.OrdersRepository;
import com.smartorder.orders.service.OrdersService;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        RestaurantTable table = tableService.findByCompanyIdAndTableId(companyId, request.getTableId());
        List<Item> items = itemService.findByCompanyIdAndItemIds(companyId, itemIds);
        Map<Long, Integer> itemPriceMap = items.stream().collect(Collectors.toMap(Item::getId, Item::getPrice));

        List<ItemOrder> itemOrders = itemOrderRequests.stream().map(req -> ItemOrder.create(req.getItemId(), req.getQuantity())).collect(Collectors.toList());
        Orders orders = Orders.create(table, itemOrders, itemPriceMap);
        Orders savedOrders = ordersRepository.save(orders);

        List<SaveOrdersResponse.ItemOrderResponse> itemOrderResponses = savedOrders.getItemOrders().stream()
                .map(req -> new SaveOrdersResponse.ItemOrderResponse(req.getItem().getItemName(), req.getItem().getPrice(), req.getQuantity(), req.getOrderSeq()))
                .collect(Collectors.toList());
        return new SaveOrdersResponse(savedOrders.getTotalPrice(), itemOrderResponses);
    }
}
