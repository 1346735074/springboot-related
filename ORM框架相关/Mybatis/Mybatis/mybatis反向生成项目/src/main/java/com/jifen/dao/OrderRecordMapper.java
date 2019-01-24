package com.jifen.dao;

import com.jifen.entity.OrderRecord;

public interface OrderRecordMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(OrderRecord record);

    int insertSelective(OrderRecord record);

    OrderRecord selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(OrderRecord record);

    int updateByPrimaryKey(OrderRecord record);
}