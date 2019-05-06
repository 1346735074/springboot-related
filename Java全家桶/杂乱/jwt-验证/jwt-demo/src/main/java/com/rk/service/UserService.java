package com.rk.service;

import com.rk.dataobject.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by nuonuo
 * 2018/8/9 下午 4:59
 */
@Service
@Slf4j
public class UserService {

    /*模拟数据库*/
    static List<User> list = new CopyOnWriteArrayList<>();

    public UserService() {
        User user = new User("1", "123", "123");
        list.add(user);
        log.info("【初始化用户集合】 list={}", list);
    }

    /**
     * userId查询用户
     *
     * @param userId
     * @return
     */
    public User findUserById(String userId) {
        for (User u : list) {
            if (u.getId().equals(userId)) {
                return u;
            }
        }
        return null;
    }

    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    public User findByUsername(User user) {
        for (User u : list) {
            if (u.getId().equals(user.getId())) {
                return u;
            }
        }
        return null;
    }
}
