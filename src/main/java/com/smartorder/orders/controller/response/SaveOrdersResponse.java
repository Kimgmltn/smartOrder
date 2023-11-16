package com.smartorder.orders.controller.response;

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
    private int totalPrice;
    private List<ItemOrderResponse> items;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ItemOrderResponse {
        private Long itemName;
        private int price;
        private Integer quantity;
    }
}
