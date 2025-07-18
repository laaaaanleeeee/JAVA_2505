package com.data.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllTaskController {

    @GetMapping("hello")
    public ResponseEntity<?> GetHW() {
        return new ResponseEntity<>("Hello Spring Boot", HttpStatus.OK);
    }

    @GetMapping("greet")
    public ResponseEntity<?> Greet(
            @RequestParam(required = false, defaultValue = "Chào bạn") String name
    ) {
        return new ResponseEntity<>(name, HttpStatus.OK);
    }


    @GetMapping("sum")
    public ResponseEntity<?> Sum(
            @RequestParam(required = false, defaultValue = "Tổng: 0") Integer a,
            @RequestParam(required = false, defaultValue = "Tổng: 0") Integer b
    ) {
        Integer sum = a + b;
        return new ResponseEntity<>("Tổng: " + sum, HttpStatus.OK);
    }

    @GetMapping("users/{userId}/posts/{postId}")
    public ResponseEntity<?> getPosts(@PathVariable Integer userId,
                                   @PathVariable Integer postId) {
        return new ResponseEntity<>("Xem bài " + postId + " của user " + userId, HttpStatus.OK);
    }


    @GetMapping("square/{num}")
    public ResponseEntity<?> getPow(@PathVariable Integer num) {
        return new ResponseEntity<>("Bình phương là: " + Math.pow(num, 2), HttpStatus.OK);
    }


    @GetMapping("rectangle/{width}/{height}")
    public ResponseEntity<?> GetArea(@PathVariable Integer width,
                                     @PathVariable Integer height) {
        return new ResponseEntity<>("Diện tích HCN là: " + (width * height), HttpStatus.OK);
    }

}
