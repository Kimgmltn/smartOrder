package com.smartorder.restaurantTable.repository;

import com.smartorder.restaurantTable.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable,Long> {
    Optional<RestaurantTable> findByCompany_IdAndTableNo(Long companyId, String tableNo);
    Optional<RestaurantTable> findByCompany_IdAndId(Long companyId, Long tableId);
}
