package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.mapper.DsmDatasetMapper;
import com.heb.guitar.service.DsmDatasetService;
import com.heb.guitar.vo.profession.req.DatasetReqVO;
import com.heb.guitar.vo.profession.resp.DatasetRespVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DsmDatasetServiceImpl implements DsmDatasetService {

    @Resource
    private DsmDatasetMapper dsmDatasetMapper;

    @Override
    public List<DsmDataset> selectByDatasource(DsmDataset dsmDataset) {
        return dsmDatasetMapper.selectByDatasource(dsmDataset);
    }

    @Override
    public int batchSave(List<DsmDataset> list) {
        for(DsmDataset dsmDataset : list){
            dsmDataset.setDatasetId(UUID.randomUUID().toString());
            dsmDataset.setUpdateTime(new Date());
        }
        return dsmDatasetMapper.batchSave(list);
    }

    @Override
    public List<DsmDataset> selectByDatasourceId(String datasourceId) {
        return dsmDatasetMapper.selectByDatasourceId(datasourceId);
    }

    @Override
    public List<DatasetRespVO> selectAll(DatasetReqVO datasetReqVO) {
        return dsmDatasetMapper.selectAll(datasetReqVO);
    }

    @Override
    public long datasetCount(DatasetReqVO datasetReqVO) {
        return dsmDatasetMapper.datasetCount(datasetReqVO);
    }

    @Override
    public int updateByPrimaryKeySelective(DsmDataset record) {
        return dsmDatasetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String datasetId) {
        return dsmDatasetMapper.deleteByPrimaryKey(datasetId);
    }
}
