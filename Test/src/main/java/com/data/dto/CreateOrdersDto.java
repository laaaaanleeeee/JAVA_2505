package com.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateOrdersDto {
    private String productName;
    private float productPrice;
    private int quantity;
    private Date orderDate;
    private Date updateDate;
}
