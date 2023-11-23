package com.smartorder.orders.service.impl;

import com.smartorder.item.entity.Item;
import com.smartorder.item.service.ItemService;
import com.smartorder.itemOrder.entity.ItemOrder;
import com.smartorder.orders.dto.request.AddOrdersRequest;
import com.smartorder.orders.dto.request.ItemOrderRequest;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.AddOrdersResponse;
import com.smartorder.orders.dto.response.SaveOrdersResponse;
import com.smartorder.orders.entity.Orders;
import com.smartorder.orders.exception.OrdersException;
import com.smartorder.orders.repository.OrdersRepository;
import com.smartorder.orders.service.OrdersService;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final RestaurantTableService tableService;
    private final ItemService itemService;

    @Override
    @Transactional
    public SaveOrdersResponse saveOrder(Long companyId, Long tableId, SaveOrdersRequest request) {
        List<ItemOrderRequest> itemOrderRequests = request.getItemOrderRequests();
        List<Long> itemIds = itemOrderRequests.stream().map(req -> req.getItemId()).collect(Collectors.toList());

        RestaurantTable table = tableService.findByCompanyIdAndTableId(companyId, tableId);
        Map<Long, Integer> itemPriceMap = getItemPriceMap(companyId, itemIds);

        List<ItemOrder> itemOrders = itemOrderRequests.stream().map(req -> ItemOrder.create(req.getItemId(), req.getQuantity(), 1)).collect(Collectors.toList());
        Orders orders = Orders.create(table, itemOrders, itemPriceMap);
        Orders savedOrders = ordersRepository.save(orders);

        List<SaveOrdersResponse.ItemOrderResponse> itemOrderResponses = savedOrders.getItemOrders().stream()
                .map(req -> new SaveOrdersResponse.ItemOrderResponse(req.getItem().getItemName(), req.getItem().getPrice(), req.getQuantity(), req.getOrderSeq()))
                .collect(Collectors.toList());
        return new SaveOrdersResponse(orders.getId(), savedOrders.getTotalPrice(), itemOrderResponses);
    }

    @Override
    @Transactional
    public AddOrdersResponse addOrder(Long companyId, Long tableId, Long orderId, AddOrdersRequest request) {
        Optional<Orders> ordersOptional = ordersRepository.findById(orderId);
        if(!ordersOptional.isPresent()){
            throw new OrdersException("존재하지 않는 주문입니다.");
        }

        Orders order = ordersOptional.get();
        List<ItemOrderRequest> itemOrderRequests = request.getItems();
        List<Long> itemIds = request.getItems().stream().map(ItemOrderRequest::getItemId).collect(Collectors.toList());
        Map<Long, Integer> itemPriceMap = getItemPriceMap(companyId, itemIds);

        Integer existMaxOrderSeq = order.getItemOrders().stream().map(ItemOrder::getOrderSeq).max(Integer::compare).get();
        int nextOrderSeq = existMaxOrderSeq + 1;
        List<ItemOrder> itemOrders = itemOrderRequests.stream().map(req -> ItemOrder.create(req.getItemId(), req.getQuantity(), nextOrderSeq)).collect(Collectors.toList());

        order.addOrder(itemOrders, itemPriceMap);
        ordersRepository.save(order);

        // TODO : return 값을 기존  DTO renaming 으로 사용할건가? 아니면 새로운 DTO 생성할것인가?
        return null;
    }

    private Map<Long, Integer> getItemPriceMap(Long companyId, List<Long> itemIds) {
        List<Item> items = itemService.findByCompanyIdAndItemIds(companyId, itemIds);
        Map<Long, Integer> itemPriceMap = items.stream().collect(Collectors.toMap(Item::getId, Item::getPrice));
        return itemPriceMap;
    }
}
