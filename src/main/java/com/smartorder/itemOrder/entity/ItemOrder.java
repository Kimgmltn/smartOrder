package com.smartorder.itemOrder.entity;

import com.smartorder.common.entity.BaseEntity;
import com.smartorder.item.entity.Item;
import com.smartorder.orders.entity.Orders;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="item_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemOrder extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_order_id")
    private Long id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "order_seq")
    private Integer orderSeq;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    public static ItemOrder create(Long itemId, Integer quantity, int i) {
        return ItemOrder.builder()
                .item(new Item(itemId))
                .quantity(quantity)
                .orderSeq(i)
                .build();
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
