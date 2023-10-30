package com.smartorder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name="total_price")
    private Integer totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="table_id")
    private RestaurantTable table;
    @OneToMany(mappedBy = "orders")
    private List<ItemOrder> itemOrders = new ArrayList<>();

}
