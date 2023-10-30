package com.smartorder.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name="price")
    private Integer price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "middle_category_id")
    private MiddleCategory middleCategory;
    @OneToMany(mappedBy = "item")
    private List<ItemOrder> itemOrders = new ArrayList<>();
}
