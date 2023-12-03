package com.smartorder.orders.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartorder.orders.dto.response.OrderListResponse;
import lombok.RequiredArgsConstructor;

import static com.smartorder.itemOrder.entity.QItemOrder.itemOrder;
import static com.smartorder.orders.entity.QOrders.orders;

@RequiredArgsConstructor
public class OrdersRepositoryCustomImpl implements OrdersRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public OrderListResponse findUseOrderListByOrderId(Long orderId) {
        return query
                .select(Projections.bean(OrderListResponse.class,
                        orders.id.as("orderId"), orders.totalPrice)
                )
                .from(orders)
                .join(orders.itemOrders, itemOrder)
                .where(orders.id.eq(orderId))
                .fetchOne();
    }
}
