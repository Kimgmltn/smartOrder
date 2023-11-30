package com.smartorder.orders.controller;

import com.smartorder.orders.dto.request.AddOrdersRequest;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.OrderListResponse;
import com.smartorder.orders.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/v1/{companyId}/{tableId}/orders")
    public ResponseEntity<OrderListResponse> saveOrders(@PathVariable("companyId") Long companyId, @PathVariable("tableId") Long tableId, @RequestBody SaveOrdersRequest request) {
        OrderListResponse saveOrdersResponse = ordersService.saveOrder(companyId, tableId, request);
        return ResponseEntity.ok().body(saveOrdersResponse);
    }

    @PostMapping("/v1/{companyId}/{tableId}/orders/{orderId}/order")
    public ResponseEntity<OrderListResponse> saveOrders(@PathVariable("companyId") Long companyId, @PathVariable("tableId") Long tableId, @PathVariable("orderId") Long orderId, @RequestBody AddOrdersRequest request) {
        OrderListResponse addOrdersResponse = ordersService.addOrder(companyId, tableId, orderId, request);
        return ResponseEntity.ok().body(addOrdersResponse);
    }


}
