package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.mapper.DsmDatasourceMapper;
import com.heb.guitar.mapper.DsmDatasourceTypeMapper;
import com.heb.guitar.service.DsmDatasourceService;
import com.heb.guitar.utils.DBUtil;
import com.heb.guitar.vo.profession.req.DataSourceReqVO;
import com.heb.guitar.vo.profession.resp.DataSourceRespVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class DsmDatasourceServiceImpl implements DsmDatasourceService {

    @Resource
    private DsmDatasourceMapper dsmDatasourceMapper;
    @Resource
    private DsmDatasourceTypeMapper dsmDatasourceTypeMapper;

    @Override
    public List<DataSourceRespVO> selectAll(DataSourceReqVO vo) {
        List<DataSourceRespVO> list = dsmDatasourceMapper.selectAll(vo);
        return list;
    }

    @Override
    public long datasourceCount(DataSourceReqVO vo) {
        return dsmDatasourceMapper.datasourceCount(vo);
    }

    @Override
    public int insertSelective(DsmDatasource dsmDatasource) {
        dsmDatasource.setDatasourceId(UUID.randomUUID().toString());
        return dsmDatasourceMapper.insertSelective(dsmDatasource);
    }

    @Override
    public int deleteByPrimaryKey(String datasourceId) {
        return dsmDatasourceMapper.deleteByPrimaryKey(datasourceId);
    }

    @Override
    public int updateByPrimaryKeySelective(DsmDatasource record) {
        return dsmDatasourceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean testConnect(DsmDatasource dsmDatasource) {
        DsmDatasourceType dsmDatasourceType = dsmDatasourceTypeMapper.selectByPrimaryKey(dsmDatasource.getDatasourceType());
        Connection connection= DBUtil.getConnection(dsmDatasource,dsmDatasourceType);
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }

}
