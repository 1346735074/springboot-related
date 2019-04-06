package com.imooc.controller;

import com.imooc.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    //@Value("${girl.name}")
    //private String a;

    @GetMapping("/girl/print")
    public String print() {
        return "name:" + girlConfig.getName() + " age:" + girlConfig.getAge();
    }
}
