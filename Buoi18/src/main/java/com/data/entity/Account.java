package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "password", unique = false, nullable = false, columnDefinition = "VARCHAR(50)")
    private String password;

    @Column(name = "fullname", unique = false, nullable = false, columnDefinition = "VARCHAR(50)")
    private String fullName;


    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

}
