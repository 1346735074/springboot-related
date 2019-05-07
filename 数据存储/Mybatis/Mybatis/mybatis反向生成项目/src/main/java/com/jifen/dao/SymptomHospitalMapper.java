package com.jifen.dao;

import com.jifen.entity.SymptomHospital;

public interface SymptomHospitalMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(SymptomHospital record);

    int insertSelective(SymptomHospital record);

    SymptomHospital selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(SymptomHospital record);

    int updateByPrimaryKey(SymptomHospital record);
}