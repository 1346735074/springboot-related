package com.example.codecentric;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class CodecentricApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodecentricApplication.class, args);
    }
}
