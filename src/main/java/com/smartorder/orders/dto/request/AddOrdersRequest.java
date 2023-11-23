package com.smartorder.orders.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrdersRequest {
    private Long orderId;
    private List<ItemOrderRequest> items;
}
