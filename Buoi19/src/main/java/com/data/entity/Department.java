package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "departments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "department_name", unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
    String departmentName;


    @Column(name = "address", unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
    String address;

    @OneToMany(mappedBy = "department")
    List<Employee> employees;

}
