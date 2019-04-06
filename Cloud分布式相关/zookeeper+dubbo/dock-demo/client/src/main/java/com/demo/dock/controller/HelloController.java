package com.demo.dock.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.dock.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/18 10:39
 * @description:
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Reference
    IHelloService helloService;


    @GetMapping("plint/{name}")
    public String hello(@PathVariable(value = "name")String name){
        return helloService.echo(name);
    }
}
