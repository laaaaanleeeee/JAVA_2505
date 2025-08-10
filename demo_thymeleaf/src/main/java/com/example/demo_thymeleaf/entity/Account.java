package com.example.demo_thymeleaf.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username", unique = true, nullable = false,
    columnDefinition = "VARCHAR(100)")
    String username;

    @Column(name = "password", unique = false, nullable = false,
    columnDefinition = "VARCHAR(50)")
    String password;

    @Column(name = "full_name", unique = false, nullable = false,
    columnDefinition = "VARCHAR(70)")
    String fullName;

    @Column(name = "birthday", unique = false, nullable = true)
    @Temporal(TemporalType.DATE)
    Date birthday;
}
