package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@Entity
@Table(name = "subjects")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "subject_name", unique = false, nullable = false,
            columnDefinition = "VARCHAR(50)")
    String subjectName;


    @Column(name = "total_hour", unique = false, nullable = false,
            columnDefinition = "INT")
    int totalHour;

    @OneToMany(mappedBy = "subject")
    List<StudentSubject> studentSubjects;
}
