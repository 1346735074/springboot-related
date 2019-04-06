package com.example.activemq.controller;

import com.example.activemq.service.SpringbootJmsApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: YAO
 * @date: 2018/11/6 10:03
 * @description:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    SpringbootJmsApplicationTests springbootJmsApplicationTests;

    @GetMapping("/test01")
    public String test01()throws Exception{
        springbootJmsApplicationTests.contextLoads();
        return "success!";
    }

    @GetMapping("/test02")
    public String test02()throws Exception{
        springbootJmsApplicationTests.topicSend();
        return "success!";
    }
}
