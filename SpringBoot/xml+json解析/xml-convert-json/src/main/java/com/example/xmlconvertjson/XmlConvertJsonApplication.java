package com.example.xmlconvertjson;

import com.example.xmlconvertjson.listener.ResourceListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;

@SpringBootApplication
public class XmlConvertJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmlConvertJsonApplication.class, args);
    }

}
