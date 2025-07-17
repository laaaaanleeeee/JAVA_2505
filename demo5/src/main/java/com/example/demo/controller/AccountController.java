package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("search1")
    public ResponseEntity<?> search1(
            @RequestParam(required = false, defaultValue = "") String fullname,
            @RequestParam(required = false, defaultValue = "18") Integer age
    ) {
        System.out.println("fullname: " + fullname);
        System.out.println("age: " + age);
        return new ResponseEntity<>("fullname: " + fullname + ", age: "+ age, HttpStatus.OK);
    }



    @GetMapping("search2/{name}/{email}")
    public ResponseEntity<?> search2(
            @PathVariable String name,
            @PathVariable String email
    ) {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        return new ResponseEntity<>("Name: " + name + ", Email: " + email, HttpStatus.OK);
    }
}
