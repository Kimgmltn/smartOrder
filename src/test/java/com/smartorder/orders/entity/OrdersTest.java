package com.smartorder.orders.entity;

import com.smartorder.itemOrder.entity.ItemOrder;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {
    @DisplayName("Orders.create()로 Orders 객체를 생성할 수 있다.")
    @Test
    void crate(){
        RestaurantTable table = new RestaurantTable(1L);
        List<ItemOrder> itemOrders = List.of(ItemOrder.create(1L, 2), ItemOrder.create(2L, 3));
        Map<Long, Integer> itemPriceMap = Map.of(1L, 2000, 2L, 3000);

        Orders orders = Orders.create(table, itemOrders, itemPriceMap);
        Assertions.assertThat(orders.getItemOrders().size()).isEqualTo(2);
    }

}