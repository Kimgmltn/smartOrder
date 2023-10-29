package com.smartorder.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="table_id")
    private RestaurantTable table;
}
