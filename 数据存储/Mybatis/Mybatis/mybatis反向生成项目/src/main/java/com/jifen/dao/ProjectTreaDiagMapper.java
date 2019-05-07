package com.jifen.dao;

import com.jifen.entity.ProjectTreaDiag;

public interface ProjectTreaDiagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTreaDiag record);

    int insertSelective(ProjectTreaDiag record);

    ProjectTreaDiag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectTreaDiag record);

    int updateByPrimaryKey(ProjectTreaDiag record);
}