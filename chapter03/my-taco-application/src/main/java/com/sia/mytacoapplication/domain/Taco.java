package com.sia.mytacoapplication.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Taco {
    private Long id;
    private String name;
    private List<Ingredient> ingredients;
    private Date createdAt;
}
