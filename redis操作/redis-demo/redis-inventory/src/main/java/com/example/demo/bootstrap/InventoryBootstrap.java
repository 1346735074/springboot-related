package com.example.demo.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-25
 */
@SpringBootApplication(scanBasePackages = "com")
public class InventoryBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(InventoryBootstrap.class, args);
    }

}
