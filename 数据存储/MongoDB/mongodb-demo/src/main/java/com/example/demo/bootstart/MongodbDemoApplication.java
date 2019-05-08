package com.example.demo.bootstart;

import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Slf4j
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.example.demo.repository")
@SpringBootApplication(scanBasePackages = "com.example.demo")
public class MongodbDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MongodbDemoApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        log.info("23");
    }

}
