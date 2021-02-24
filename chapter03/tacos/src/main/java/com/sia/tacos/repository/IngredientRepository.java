package com.sia.tacos.repository;

import com.sia.tacos.entity.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    // Iterable<Ingredient> findAll();
    // Ingredient findById(String id);
    // Ingredient save(Ingredient ingredient);
}
