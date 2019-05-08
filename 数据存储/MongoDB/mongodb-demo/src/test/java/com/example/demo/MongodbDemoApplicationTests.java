package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.example.demo")
@SpringBootTest(classes = MongodbDemoApplicationTests.class, properties = "application.properties")
public class MongodbDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

}
