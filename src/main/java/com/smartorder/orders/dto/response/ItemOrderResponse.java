package com.smartorder.orders.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderResponse {
    private String itemName;
    private Integer price;
    private Integer quantity;
    private Integer orderSeq;
}
