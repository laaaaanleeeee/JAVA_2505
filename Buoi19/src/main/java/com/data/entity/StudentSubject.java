package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "student_subjects")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
            @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
            @JoinColumn(name = "subject_id")
    Subject subject;
}
