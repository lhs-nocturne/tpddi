package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmColumn;

public interface DsmColumnMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(DsmColumn record);

    int insertSelective(DsmColumn record);

    DsmColumn selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(DsmColumn record);

    int updateByPrimaryKey(DsmColumn record);
}