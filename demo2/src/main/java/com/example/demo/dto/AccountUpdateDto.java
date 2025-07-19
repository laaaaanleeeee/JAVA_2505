package com.example.demo.dto;

import lombok.Data;

@Data
public class AccountUpdateDto {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
}
