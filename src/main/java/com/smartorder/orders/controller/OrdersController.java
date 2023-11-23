package com.smartorder.orders.controller;

import com.smartorder.orders.dto.request.AddOrdersRequest;
import com.smartorder.orders.dto.request.SaveOrdersRequest;
import com.smartorder.orders.dto.response.AddOrdersResponse;
import com.smartorder.orders.dto.response.SaveOrdersResponse;
import com.smartorder.orders.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/v1/{companyId}/{tableId}/orders")
    public ResponseEntity<SaveOrdersResponse> saveOrders(@PathVariable("companyId") Long companyId, @PathVariable("tableId") Long tableId, @RequestBody SaveOrdersRequest request) {
        SaveOrdersResponse saveOrdersResponse = ordersService.saveOrder(companyId, tableId, request);
        return ResponseEntity.ok().body(saveOrdersResponse);
    }

    @PostMapping("/v1/{companyId}/{tableId}/orders/{orderId}/order")
    public ResponseEntity<AddOrdersResponse> saveOrders(@PathVariable("companyId") Long companyId, @PathVariable("tableId") Long tableId, @PathVariable("orderId") Long orderId, @RequestBody AddOrdersRequest request) {
        AddOrdersResponse addOrdersResponse = ordersService.addOrder(companyId, tableId, orderId, request);
        return ResponseEntity.ok().body(addOrdersResponse);
    }


}
