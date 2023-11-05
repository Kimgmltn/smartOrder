package com.smartorder.repository;

import com.smartorder.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
