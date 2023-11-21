package com.smartorder.orders.entity;

import com.smartorder.common.entity.BaseEntity;
import com.smartorder.itemOrder.entity.ItemOrder;
import com.smartorder.orders.enums.OrderStatus;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name="total_price")
    private Integer totalPrice;
    @Enumerated(value = EnumType.STRING)
    @Column(name="order_status")
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="table_id")
    private RestaurantTable table;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ItemOrder> itemOrders = new ArrayList<>();

    public Orders(Long orderId) {
        this.orderId = orderId;
    }

    public static Orders create(RestaurantTable table, List<ItemOrder> itemOrders, Map<Long, Integer> itemPriceMap) {

        int calculatedTotalPrice = itemOrders.stream().map(req -> req.getQuantity() * itemPriceMap.get(req.getItem().getId())).reduce(0, Integer::sum);

        return Orders.builder()
                .table(table)
                .totalPrice(calculatedTotalPrice)
                .itemOrders(itemOrders)
                .orderStatus(OrderStatus.USE)
                .build();
    }

}
