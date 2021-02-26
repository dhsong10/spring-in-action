package com.sia.mytacoapplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TacoOrder_Taco")
public class TacoOrderTaco {
    private Long orderId;
    private Long tacoId;
}
