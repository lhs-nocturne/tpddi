package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmQueryViewColumn;

import java.util.List;

public interface DsmQueryViewColumnMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(DsmQueryViewColumn record);

    int insertSelective(DsmQueryViewColumn record);

    DsmQueryViewColumn selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(DsmQueryViewColumn record);

    int updateByPrimaryKey(DsmQueryViewColumn record);

    List<DsmQueryViewColumn> listByViewId(DsmQueryViewColumn dsmQueryViewColumn);

    int batchSave(List<DsmQueryViewColumn> list);

    int batchDeleteViewColumns(List<DsmQueryViewColumn> list);
}