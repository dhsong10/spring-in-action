package com.sia.tacos.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name mest be at least 5 characters long")
    private String name;

    @NotNull(message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients; 

    private Date createdAt;
}
