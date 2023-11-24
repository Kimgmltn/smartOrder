package com.smartorder.orders.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrdersResponse {
    private Long orderId;
    private int totalPrice;
    private List<ItemOrderResponse> items;
}
