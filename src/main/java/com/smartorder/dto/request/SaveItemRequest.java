package com.smartorder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveItemRequest {
    private Long middleCategoryId;
    private String itemName;
    private Integer price;
}
