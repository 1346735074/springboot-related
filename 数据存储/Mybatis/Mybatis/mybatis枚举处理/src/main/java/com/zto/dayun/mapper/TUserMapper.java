package com.zto.dayun.mapper;

import com.zto.dayun.entity.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String id);
}