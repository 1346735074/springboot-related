package com.example.demo.bootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class MongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbDemoApplication.class, args);
    }

}
