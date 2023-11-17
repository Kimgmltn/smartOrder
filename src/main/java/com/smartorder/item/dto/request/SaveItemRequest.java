package com.smartorder.item.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveItemRequest {
    private Long companyId;
    private Long categoryId;
    private List<SaveItem> items;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SaveItem{
        private String itemName;
        private Integer price;
    }
}
