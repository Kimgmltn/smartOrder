package com.smartorder.item.entity;


import com.smartorder.category.entity.Category;
import com.smartorder.common.entity.BaseEntity;
import com.smartorder.entity.ItemOrder;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name="price")
    private Integer price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "item")
    private List<ItemOrder> itemOrders = new ArrayList<>();

    public Item(Long itemId) {
        this.itemId = itemId;
    }
}