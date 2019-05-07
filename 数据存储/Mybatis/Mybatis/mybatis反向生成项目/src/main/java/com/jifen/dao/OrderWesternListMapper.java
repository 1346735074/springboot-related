package com.jifen.dao;

import com.jifen.entity.OrderWesternList;

public interface OrderWesternListMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(OrderWesternList record);

    int insertSelective(OrderWesternList record);

    OrderWesternList selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(OrderWesternList record);

    int updateByPrimaryKey(OrderWesternList record);
}