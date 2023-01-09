package com.example.dibootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DibootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DibootDemoApplication.class, args);
    }

}
