package com.example.demo_thymeleaf.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "product_name", unique = false, nullable = false, columnDefinition = "VARCHAR(100)")
    String productName;

    @Column(name = "description", unique = false, nullable = true, columnDefinition = "VARCHAR(255)")
    String description;

    @Column(name = "price", unique = false, nullable = false, columnDefinition = "DECIMAL(10,2)")
    BigDecimal price;

    @Column(name = "brand", unique = false, nullable = false, columnDefinition = "VARCHAR(50)")
    String brand;

    @Column(name = "quantity", unique = false, nullable = false, columnDefinition = "INT")
    int quantity;

    @Column(name = "created_date", unique = false, nullable = true)
    LocalDateTime createdDate;

    @Column(name = "updated_date", unique = false, nullable = true)
    LocalDateTime updatedDate;

    @Column(name = "img_url", unique = false, nullable = true, columnDefinition = "VARCHAR(255)")
    String imgUrl;

    @Column(name = "status", unique = false, nullable = false, columnDefinition = "ENUM('Active', 'Inactive') DEFAULT 'Active'")
    String status;

    @ManyToOne
            @JoinColumn(name = "category_id")
    Category category;
}
