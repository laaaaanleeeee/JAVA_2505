package com.data.controller;

import com.data.dto.ProductCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductCreateDto productCreateDto) {
        if(productCreateDto.getProductName().isEmpty()) {
            return ResponseEntity.badRequest().body("Product name is Empty");
        }
        else {
            return ResponseEntity.ok(productCreateDto);
        }
    }
}
