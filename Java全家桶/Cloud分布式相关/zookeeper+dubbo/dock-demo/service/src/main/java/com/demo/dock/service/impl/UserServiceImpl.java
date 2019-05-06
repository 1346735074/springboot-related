package com.demo.dock.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.dock.entity.User;
import com.demo.dock.service.IUserService;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/18 12:42
 * @description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser() {
        User user = new User("小明","123123");
        return user;
    }
}
