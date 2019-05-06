package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.*"})
@SpringBootApplication
public class AdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdapterApplication.class, args);
    }
}
