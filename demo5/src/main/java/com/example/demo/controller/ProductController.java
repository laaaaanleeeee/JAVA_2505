package com.example.demo.controller;

import com.example.demo.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @GetMapping("products")
    public List<Product>  getAllProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Car", 10));
        products.add(new Product(2, "Bike", 5));

        return products;
    }

    @GetMapping("getById")
    public Product getProductById() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Car", 10));
        products.add(new Product(2, "Bike", 5));

        return products.get(1);
    }


    @GetMapping("listProducts")
    public ResponseEntity<?> getListProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Car", 10));
        products.add(new Product(2, "Bike", 5));

        Product airplane = new Product(3, "Airbus",  100);
        return new ResponseEntity<>(airplane, HttpStatus.OK);
    }


}

