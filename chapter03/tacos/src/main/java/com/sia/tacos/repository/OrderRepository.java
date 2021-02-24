package com.sia.tacos.repository;

import com.sia.tacos.entity.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    // Order save(Order order);
}
