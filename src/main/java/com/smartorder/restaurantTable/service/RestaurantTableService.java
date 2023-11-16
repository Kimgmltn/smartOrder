package com.smartorder.restaurantTable.service;

import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.controller.response.SaveTablesResponse;
import com.smartorder.restaurantTable.entity.RestaurantTable;

public interface RestaurantTableService {

    SaveTablesResponse saveTables(SaveTablesRequest request);

    RestaurantTable findByCompanyIdAndTableNo(Long companyId, String tableNo);

    RestaurantTable findByCompanyIdAndTableId(Long companyId, Long tableId);
}
