package com.sia.mytacoapplication.repository;

import com.sia.mytacoapplication.domain.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
