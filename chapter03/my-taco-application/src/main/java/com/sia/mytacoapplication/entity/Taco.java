package com.sia.mytacoapplication.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Taco")
public class Taco {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "createdAt")
    private Timestamp createdAt; 
}
