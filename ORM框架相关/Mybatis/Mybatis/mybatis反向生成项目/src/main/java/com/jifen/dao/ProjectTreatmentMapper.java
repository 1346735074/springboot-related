package com.jifen.dao;

import com.jifen.entity.ProjectTreatment;

public interface ProjectTreatmentMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(ProjectTreatment record);

    int insertSelective(ProjectTreatment record);

    ProjectTreatment selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(ProjectTreatment record);

    int updateByPrimaryKey(ProjectTreatment record);
}