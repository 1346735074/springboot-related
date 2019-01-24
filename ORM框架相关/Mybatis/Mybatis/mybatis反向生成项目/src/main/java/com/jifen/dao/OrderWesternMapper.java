package com.jifen.dao;

import com.jifen.entity.OrderWestern;

public interface OrderWesternMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(OrderWestern record);

    int insertSelective(OrderWestern record);

    OrderWestern selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(OrderWestern record);

    int updateByPrimaryKey(OrderWestern record);
}