package com.sia.mytacoapplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Taco_Ingredient")
public class TacoIngredient {
    private Long tacoId;
    private String ingredientId;
}
