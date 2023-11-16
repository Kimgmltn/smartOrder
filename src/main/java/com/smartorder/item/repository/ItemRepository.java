package com.smartorder.item.repository;

import com.smartorder.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByItemNameAndCategory_Id(String itemName, Long categoryId);

    @Query("select i from Item i where i.category.company.id = :companyId and i.id in :itemIds")
    List<Item> findByCompanyIdAndItemIds(@Param("companyId") Long companyId, @Param("itemIds") List<Long> itemIds);
}
