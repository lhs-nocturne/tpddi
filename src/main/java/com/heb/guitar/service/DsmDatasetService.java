package com.heb.guitar.service;

import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.vo.profession.req.DatasetReqVO;
import com.heb.guitar.vo.profession.resp.DatasetRespVO;
import java.util.List;

public interface DsmDatasetService {

    List<DsmDataset> selectByDatasource(DsmDataset dsmDataset);

    int batchSave(List<DsmDataset> list);

    List<DsmDataset> selectByDatasourceId(String datasourceId);

    List<DatasetRespVO> selectAll(DatasetReqVO datasetReqVO);

    long datasetCount(DatasetReqVO datasetReqVO);

    int updateByPrimaryKeySelective(DsmDataset record);

    int deleteByPrimaryKey(String datasetId);

}
