package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProductController {

    @GetMapping("getData0")
    public String getData0() {
        return "Name: Ngọc";
    }

    @GetMapping("getData1")
    public int getData1() {
        return 20;
    }

    @GetMapping("getData2")
    public ResponseEntity<?> getData2() {
        return new ResponseEntity<>(25, HttpStatus.CREATED);
    }

    @GetMapping("getData3")
    public ResponseEntity<?> getData3() {
        return new ResponseEntity<>("Name: Chien", HttpStatus.OK);
    }

    @GetMapping("getData4")
    public ResponseEntity<?> getData4() {
        return new ResponseEntity<>(new Date(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("getData5")
    public ResponseEntity<?> getData5() {
        return new ResponseEntity<>(true, HttpStatus.CONFLICT);
    }


    @PostMapping("Create6")
    public ResponseEntity<?> createData6 () {
        return new ResponseEntity<>("Created account", HttpStatus.OK);
    }
}

