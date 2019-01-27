package com.example.controller;

import com.example.entity.MiaoshaUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nuonuo
 * 2018/8/22 下午 5:56
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @GetMapping("user")
    public String user(MiaoshaUser user) {
        log.info("name={},pwd={}", user.getName(), user.getPwd());
        return "你好这是个测试";
    }

}
