package com.sia.mytacoapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
}
