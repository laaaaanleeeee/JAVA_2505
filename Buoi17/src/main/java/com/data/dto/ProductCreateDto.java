package com.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCreateDto {
    private int id;
    private String productName;
    private int price;
    private Date createdDate;
}
