package com.example.demo_thymeleaf.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "category_name", unique = false, nullable = false,
    columnDefinition = "VARCHAR(100)")
    String categoryName;

    @Column(name = "description", unique = false, nullable = true,
    columnDefinition = "VARCHAR(255)")
    String description;

    @Column(name = "created_date", nullable = true)
    LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = true)
    LocalDateTime updatedDate;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
