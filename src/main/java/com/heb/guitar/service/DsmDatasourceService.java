package com.heb.guitar.service;

import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.vo.profession.req.DataSourceReqVO;
import com.heb.guitar.vo.profession.resp.DataSourceRespVO;

import java.util.List;

public interface DsmDatasourceService {

    List<DataSourceRespVO> selectAll(DataSourceReqVO vo);

    long datasourceCount(DataSourceReqVO vo);

    int insertSelective(DsmDatasource dsmDatasource);

    int deleteByPrimaryKey(String datasourceId);

    int updateByPrimaryKeySelective(DsmDatasource record);

    boolean testConnect(DsmDatasource dsmDatasource);

}
