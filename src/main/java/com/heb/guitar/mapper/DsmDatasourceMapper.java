package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.vo.profession.req.DataSourceReqVO;
import com.heb.guitar.vo.profession.resp.DataSourceRespVO;

import java.util.List;

public interface DsmDatasourceMapper {
    int deleteByPrimaryKey(String datasourceId);

    int insert(DsmDatasource record);

    int insertSelective(DsmDatasource record);

    DsmDatasource selectByPrimaryKey(String datasourceId);

    int updateByPrimaryKeySelective(DsmDatasource record);

    int updateByPrimaryKey(DsmDatasource record);

    List<DataSourceRespVO> selectAll(DataSourceReqVO vo);

    long datasourceCount(DataSourceReqVO vo);

}