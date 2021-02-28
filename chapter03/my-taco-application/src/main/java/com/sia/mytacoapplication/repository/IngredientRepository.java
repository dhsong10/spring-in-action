package com.sia.mytacoapplication.repository;

import java.util.List;

import com.sia.mytacoapplication.domain.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();
}
