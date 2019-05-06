package com.imooc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args) {
        //TODO 这是个注释
        SpringApplication.run(ConfigApplication.class, args);
    }
}
