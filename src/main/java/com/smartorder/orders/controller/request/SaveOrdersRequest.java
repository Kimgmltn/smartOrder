package com.smartorder.orders.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrdersRequest {
    private Long companyId;
    private Long tableId;
    private List<ItemOrderRequest> itemOrderRequests;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ItemOrderRequest{
        private Long itemId;
        private Integer quantity;
    }
}
