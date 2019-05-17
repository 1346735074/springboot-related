package com.demo.dock.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.dock.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/18 12:44
 * @description:
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    IUserService userService;

    @GetMapping("get")
    public Object getUser(){
        return userService.getUser();
    }
}
