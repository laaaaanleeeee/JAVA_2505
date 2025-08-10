package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Buoi18Application {

    public static void main(String[] args) {
        SpringApplication.run(Buoi18Application.class, args);
    }

}
