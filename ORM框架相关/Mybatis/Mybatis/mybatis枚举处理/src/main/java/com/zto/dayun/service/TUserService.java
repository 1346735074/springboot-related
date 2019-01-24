package com.zto.dayun.service;

import com.zto.dayun.entity.TUser;
import com.zto.dayun.enums.EnumStatus;
import com.zto.dayun.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YAO
 * @Date: 2018/9/30 10:48
 * @Description:
 */
@Service
public class TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    public TUser findById(){
        TUser tUser= tUserMapper.selectByPrimaryKey("1231");
        return tUser;
    }

    public int add(){
        TUser tUser = new TUser("1231","123","小红", EnumStatus.CANCEL,EnumStatus.CANCEL,EnumStatus.CANCEL);
        return tUserMapper.insertSelective(tUser);
    }
}
