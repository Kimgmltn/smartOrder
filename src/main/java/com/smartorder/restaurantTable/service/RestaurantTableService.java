package com.smartorder.restaurantTable.service;

import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.controller.response.SaveTablesResponse;

public interface RestaurantTableService {

    SaveTablesResponse saveTables(SaveTablesRequest request);
}
