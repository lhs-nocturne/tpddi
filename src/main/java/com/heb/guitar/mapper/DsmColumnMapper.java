package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmColumn;

import java.util.List;

public interface DsmColumnMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(DsmColumn record);

    int insertSelective(DsmColumn record);

    DsmColumn selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(DsmColumn record);

    int updateByPrimaryKey(DsmColumn record);

    List<DsmColumn> selectByDatasetId(DsmColumn dsmColumn);

    int batchSave(List<DsmColumn> dsmColumns);

    int deleteByDatasetId(String datasetId);

    int batchDeleteColumns(List<DsmColumn> list);


}