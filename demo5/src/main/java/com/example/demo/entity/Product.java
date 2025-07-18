package com.example.demo.entity;

public class Product {
    private Integer id;
    private String productName;
    private float productPrice;


    public Product(Integer id, String productName, float productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
