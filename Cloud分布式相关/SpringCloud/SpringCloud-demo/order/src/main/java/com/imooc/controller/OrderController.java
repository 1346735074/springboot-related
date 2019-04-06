package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping("/print")
    public String print(){
        return "这个是个测试的order";
    }

    @GetMapping("/print1")
    public String print1(){
        return "这个是个测试(1)的order";
    }
}
