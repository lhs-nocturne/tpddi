package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.vo.profession.req.DatasetReqVO;
import com.heb.guitar.vo.profession.resp.DatasetRespVO;

import java.util.List;

public interface DsmDatasetMapper {
    int deleteByPrimaryKey(String datasetId);

    int insert(DsmDataset record);

    int insertSelective(DsmDataset record);

    DsmDataset selectByPrimaryKey(String datasetId);

    int updateByPrimaryKeySelective(DsmDataset record);

    int updateByPrimaryKey(DsmDataset record);

    List<DsmDataset> selectByDatasource(DsmDataset dsmDataset);

    int batchSave(List<DsmDataset> list);

    List<DsmDataset> selectByDatasourceId(String datasourceId);

    List<DatasetRespVO> selectAll(DatasetReqVO datasetReqVO);

    long datasetCount(DatasetReqVO datasetReqVO);
}