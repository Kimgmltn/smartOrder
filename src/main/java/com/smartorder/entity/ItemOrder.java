package com.smartorder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="item_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_order_id")
    private Long itemOrderId;
    @Column(name = "quantity")
    private Integer quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

}
