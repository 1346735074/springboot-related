package com.jifen.dao;

import com.jifen.entity.OrderDiagnosis;

public interface OrderDiagnosisMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(OrderDiagnosis record);

    int insertSelective(OrderDiagnosis record);

    OrderDiagnosis selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(OrderDiagnosis record);

    int updateByPrimaryKey(OrderDiagnosis record);
}