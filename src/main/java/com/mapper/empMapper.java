package com.mapper;

import com.domain.emp;

import java.util.ArrayList;

public interface empMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(emp record);

    int insertSelective(emp record);

    emp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(emp record);

    int updateByPrimaryKey(emp record);

    ArrayList<emp>GetAll();
}