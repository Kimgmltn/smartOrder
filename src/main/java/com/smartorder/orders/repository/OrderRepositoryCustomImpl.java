package com.smartorder.orders.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartorder.orders.dto.response.OrderListResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{

    private final JPAQueryFactory query;

    @Override
    public List<OrderListResponse> findOrderList() {
        return null;
    }
}
