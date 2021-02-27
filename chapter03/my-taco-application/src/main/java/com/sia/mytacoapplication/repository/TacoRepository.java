package com.sia.mytacoapplication.repository;

import com.sia.mytacoapplication.domain.Taco;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    
}
