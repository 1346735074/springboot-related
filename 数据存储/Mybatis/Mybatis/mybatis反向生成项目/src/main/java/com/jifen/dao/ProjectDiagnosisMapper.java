package com.jifen.dao;

import com.jifen.entity.ProjectDiagnosis;

public interface ProjectDiagnosisMapper {
    int deleteByPrimaryKey(String onlyId);

    int insert(ProjectDiagnosis record);

    int insertSelective(ProjectDiagnosis record);

    ProjectDiagnosis selectByPrimaryKey(String onlyId);

    int updateByPrimaryKeySelective(ProjectDiagnosis record);

    int updateByPrimaryKey(ProjectDiagnosis record);
}