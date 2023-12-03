package com.smartorder.itemOrder.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartorder.orders.dto.response.ItemOrderResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.smartorder.item.entity.QItem.item;
import static com.smartorder.itemOrder.entity.QItemOrder.itemOrder;

@RequiredArgsConstructor
public class ItemOrderRepositoryCustomImpl implements ItemOrderRepositoryCustom{

    private final JPAQueryFactory query;

    @Override
    public List<ItemOrderResponse> findUseItemOrderListByOrderId(Long orderId) {
        return query
                .select(Projections.bean(ItemOrderResponse.class,
                        item.itemName, item.price, itemOrder.quantity, itemOrder.orderSeq))
                .from(itemOrder)
                .join(itemOrder.item, item)
                .where(itemOrder.orders.id.eq(orderId))
                .orderBy(itemOrder.id.asc(), itemOrder.orderSeq.desc())
                .fetch();
    }
}
