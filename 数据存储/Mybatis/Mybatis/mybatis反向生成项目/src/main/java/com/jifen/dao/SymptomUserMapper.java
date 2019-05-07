package com.jifen.dao;

import com.jifen.entity.SymptomUser;

public interface SymptomUserMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(SymptomUser record);

    int insertSelective(SymptomUser record);

    SymptomUser selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(SymptomUser record);

    int updateByPrimaryKey(SymptomUser record);
}