package com.smartorder.dto.request;

import com.smartorder.entity.ItemOrder;
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
    private Long tableId;
    private Integer total_price;
    private List<ItemOrderRequest> itemOrderRequests;

    public static class ItemOrderRequest{
        private Long itemId;
        private Integer quantity;
    }
}
