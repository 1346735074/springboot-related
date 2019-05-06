package com.rk.controller;

import com.rk.annoations.PassToken;
import com.rk.annoations.UserLoginToken;
import com.rk.dataobject.User;
import com.rk.service.TokenService;
import com.rk.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nuonuo
 * 2018/8/9 下午 5:30
 */
@RestController
@RequestMapping("api")
public class UserContorller {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    //登录
    //@RequestBody User user,
    @RequestMapping("/login")
    public Object login(String username, String pwd) throws JSONException {
        User user = new User("1", username, pwd);
        Map<String, Object> map = new HashMap<>();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            map.put("message", "登录失败,用户不存在");
            return map;
        }
        if (!userForBase.getPassword().equals(user.getPassword())) {
            map.put("message", "登录失败,密码错误");
            return map;
        }
        String token = tokenService.getToken(userForBase);
        map.put("token", token);
        map.put("user", userForBase);
        return map;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

    @GetMapping("/test")
    public String test() {
        return "这个是测试";
    }

    @PassToken
    @GetMapping("/test1")
    public String test1() {
        return "这个是测试";
    }
}
