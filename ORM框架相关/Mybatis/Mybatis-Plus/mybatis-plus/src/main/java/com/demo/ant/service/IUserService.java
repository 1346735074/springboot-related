package com.demo.ant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.ant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YAO
 * @since 2018-10-11
 */
public interface IUserService extends IService<User> {

    /**
     * 分页查询
     * @param page
     * @param age
     * @return
     */
    IPage<User> selectUserPage(Page<User> page, Integer age);
}
