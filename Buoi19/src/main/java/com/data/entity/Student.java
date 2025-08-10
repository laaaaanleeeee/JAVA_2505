package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "full_name", unique = false, nullable = false,
    columnDefinition = "VARCHAR(100)")
    String fullName;


    @Column(name = "student_code", unique = true, nullable = false,
            columnDefinition = "VARCHAR(10)")
    String studentCode;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthday", unique = false, nullable = false)
    Date birthday;


    @OneToMany(mappedBy = "student")
    List<StudentSubject> studentSubjects;
}
