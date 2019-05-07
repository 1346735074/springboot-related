package com.example.demo.bootstrap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author zhaoyao
 * @version 1.0
 * @date 2019-01-16
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        log.info("user={}", new User("123", "123"));
    }

    @Data
    @AllArgsConstructor
    public static class User{
        private String name;
        private String pwd;
    }
}
