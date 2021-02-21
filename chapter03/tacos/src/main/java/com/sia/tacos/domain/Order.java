package com.sia.tacos.domain;

import lombok.Data;

@Data
public class Order {
    private String devliveryName;
    private String delvieryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
