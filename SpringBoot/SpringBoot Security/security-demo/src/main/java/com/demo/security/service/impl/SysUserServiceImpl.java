package com.demo.security.service.impl;

import com.demo.security.entity.SysUser;
import com.demo.security.mapper.SysUserMapper;
import com.demo.security.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YAO
 * @since 2018-10-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
