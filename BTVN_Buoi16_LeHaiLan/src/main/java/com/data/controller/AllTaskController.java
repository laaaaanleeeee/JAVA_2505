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
    public ResponseEntity<?> getHW() {
        return new ResponseEntity<>("Hello Spring Boot", HttpStatus.OK);
    }

    @GetMapping("greet")
    public ResponseEntity<?> greet(
            @RequestParam(required = false, defaultValue = "Chào bạn") String name
    ) {
        return new ResponseEntity<>(name, HttpStatus.OK);
    }


    @GetMapping("sum")
    public ResponseEntity<?> sum(
            @RequestParam(required = false) Integer a,
            @RequestParam(required = false) Integer b) {
        if(a == null && b == null) {
            return new ResponseEntity<>("Không truyền dữ liệu cả 2", HttpStatus.BAD_REQUEST);
        }
        else if (a == null || b == null) {
            return new ResponseEntity<>("Tổng: 0", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Tổng: " + (a+b), HttpStatus.OK);

        }
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<?> getUsers(@PathVariable Integer userId) {
        return new ResponseEntity<>("User có ID: " + userId, HttpStatus.OK);
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
    public ResponseEntity<?> getArea(@PathVariable String width,
                                     @PathVariable String height) {
        try {
            Integer width2 = Integer.parseInt(width);
            Integer height2 = Integer.parseInt(height);
            return new ResponseEntity<>("Diện tích HCN là: " + (width2 * height2), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Tham số truyền 2 cạnh HCN phải là số", HttpStatus.BAD_REQUEST);
        }
    }

}
