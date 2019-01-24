package com.zto.dayun.controller;

import com.zto.dayun.entity.TUser;
import com.zto.dayun.enums.EnumStatus;
import com.zto.dayun.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: YAO
 * @Date: 2018/9/30 10:50
 * @Description:
 */
@RestController
@RequestMapping("user")
public class TUserController {

    @Autowired
    private TUserService tUserService;

    @GetMapping("test")
    public Object test(){
        EnumStatus status =EnumStatus.CANCEL;
        return status;
    }

    @GetMapping("get")
    public Object get(){
        TUser user = tUserService.findById();
        return user;
    }

    @RequestMapping("add")
    public int add(){
        return tUserService.add();
    }
}
