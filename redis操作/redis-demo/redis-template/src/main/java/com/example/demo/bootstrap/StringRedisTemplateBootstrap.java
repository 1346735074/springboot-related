package com.example.demo.bootstrap;

import com.example.demo.redis.StringRedisTemplateTest;
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
public class StringRedisTemplateBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StringRedisTemplateBootstrap.class, args);
        StringRedisTemplateTest bean = run.getBean(StringRedisTemplateTest.class);
//        bean.test();
//        bean.test1();
        bean.map();
    }
}
