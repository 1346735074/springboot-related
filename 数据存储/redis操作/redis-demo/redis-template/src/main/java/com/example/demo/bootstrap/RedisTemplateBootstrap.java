package com.example.demo.bootstrap;

import com.example.demo.redis.RedisTemplateTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-15
 */
@SpringBootApplication(scanBasePackages = "com.example.demo")
public class RedisTemplateBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(RedisTemplateBootstrap.class, args);
        RedisTemplateTest bean = run.getBean(RedisTemplateTest.class);
        bean.test();

    }
}
