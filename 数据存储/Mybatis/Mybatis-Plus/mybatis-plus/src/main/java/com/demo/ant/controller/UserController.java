package com.demo.ant.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.ant.entity.User;
import com.demo.ant.entity.enums.AgeEnum;
import com.demo.ant.service.IUserService;
import com.demo.ant.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YAO
 * @since 2018-10-11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public IUserService userService;

    @GetMapping("test")
    public Object test(){
        AgeEnum status = AgeEnum.ONE;
        return status;
    }
    @GetMapping("all")
    public Object all(){
        List<User> userList = (List<User>) userService.list(null);
        return userList;
    }

    @GetMapping("selectpage")
    public Object selectPage(){
        Page<User> page = new Page<>();
        page.setSize(5);//每页显示条数
        page.setTotal(5);//总数，当 total 不为 0 时分页插件不会进行 count 查询
//        page.setCurrent(1);//当前页

        //userIPage内存地址和page内存地址相同
        IPage<User> userIPage = userService.selectUserPage(page, 3);
        return ResultVOUtil.success(userIPage);
    }

//    @GetMapping("e")
    @RequestMapping("e")
    public Object e() throws Exception {
        throw new Exception("异常");
    }
}
