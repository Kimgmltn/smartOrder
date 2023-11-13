package com.smartorder.restaurantTable.repository;

import com.smartorder.restaurantTable.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable,Long> {
}