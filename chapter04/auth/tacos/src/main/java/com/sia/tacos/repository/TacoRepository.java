package com.sia.tacos.repository;

import com.sia.tacos.domain.Taco;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    
}
