package com.example.testheroku2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestHeroku2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestHeroku2Application.class, args);
    }
}