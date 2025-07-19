package com.data.buoi17_03.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "lession")
public class Lession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lessionName;
    private int lessionHours;

    @Enumerated(EnumType.STRING)
    private LessionTypeEnum lessionType;
    private Date createdDate;

}
