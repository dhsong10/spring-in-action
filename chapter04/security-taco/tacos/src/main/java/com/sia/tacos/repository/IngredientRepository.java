package com.sia.tacos.repository;

import com.sia.tacos.domain.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    
}
