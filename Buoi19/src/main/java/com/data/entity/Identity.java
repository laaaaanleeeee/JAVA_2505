package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "identities")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "identity_number", unique = true, nullable = false,
    columnDefinition = "VARCHAR(50)")
    String identityNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_cap", unique = false, nullable = false)
    Date ngayCap;

    @Column(name = "noi_cap", unique = false, nullable = false,
    columnDefinition = "VARCHAR(100)")
    String noiCap;

    @OneToOne
            @JoinColumn(name = "person_id", unique = true)
    Person person;
}
