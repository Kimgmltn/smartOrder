package com.smartorder.restaurantTable.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveTablesRequest {
    private Long companyId;
    private List<String> tableNos;
}
