package com.sia.mytacoapplication.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TacoOrder")
public class TacoOrder {
    @Id
    private Long id;
    @Column(name = "deliveryName")
    private String deliveryName;
    @Column(name = "deliveryCity")
    private String deliveryCity;
    @Column(name = "deliveryState")
    private String deliveryState;
    @Column(name = "deliveryStreet")
    private String deliveryStreet;
    @Column(name = "deliveryZip")
    private String deliveryZip;
    @Column(name = "ccNumber")
    private String ccNumber;
    @Column(name = "ccExpiration")
    private String ccExpiration;
    @Column(name = "ccCVV")
    private String ccCVV;
    @Column(name = "placedAt")
    private Timestamp placedAt;
}
