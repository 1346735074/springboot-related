package com.demo.ant.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.ant.entity.User;
import com.demo.ant.mapper.UserMapper;
import com.demo.ant.service.IUserService;
import com.demo.ant.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YAO
 * @since 2018-10-11
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public IPage<User> selectUserPage(Page<User> page, Integer age) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        IPage<User> userIPage = userMapper.selectPageVo(page, age);
        System.out.println("che     shi    ");
        log.info("【用户信息】 按照年龄分页查询 userIPage={}", JsonUtil.toJson(userIPage));
        return userIPage;
    }
}
