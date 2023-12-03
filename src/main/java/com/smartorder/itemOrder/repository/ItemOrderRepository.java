package com.smartorder.itemOrder.repository;

import com.smartorder.itemOrder.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long>, ItemOrderRepositoryCustom {
}
