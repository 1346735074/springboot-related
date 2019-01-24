package com.jifen.dao;

import com.jifen.entity.OrderDiagnosisList;

public interface OrderDiagnosisListMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(OrderDiagnosisList record);

    int insertSelective(OrderDiagnosisList record);

    OrderDiagnosisList selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(OrderDiagnosisList record);

    int updateByPrimaryKey(OrderDiagnosisList record);
}