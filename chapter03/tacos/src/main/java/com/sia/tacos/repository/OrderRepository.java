package com.sia.tacos.repository;

import com.sia.tacos.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
