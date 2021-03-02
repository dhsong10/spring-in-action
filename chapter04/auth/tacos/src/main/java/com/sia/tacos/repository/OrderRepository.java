package com.sia.tacos.repository;

import com.sia.tacos.domain.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
