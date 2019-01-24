package com.demo.ant.mapper;

import com.demo.ant.MybatisPlusApplicationTests;
import com.demo.ant.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther: YAO
 * @version: 1.0
 * @date: 2018/10/10 11:14
 * @description:
 */
@Component
public class UserMapperTest extends MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        Assert.assertTrue(user != null);
    }

}