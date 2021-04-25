package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.mapper.DsmDatasourceMapper;
import com.heb.guitar.mapper.DsmDatasourceTypeMapper;
import com.heb.guitar.service.DsmDatasetService;
import com.heb.guitar.service.DsmDatasourceService;
import com.heb.guitar.utils.DBUtil;
import com.heb.guitar.vo.profession.req.DataSourceReqVO;
import com.heb.guitar.vo.profession.req.DatasetSourceReqVO;
import com.heb.guitar.vo.profession.resp.DataSourceRespVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DsmDatasourceServiceImpl implements DsmDatasourceService {

    @Resource
    private DsmDatasourceMapper dsmDatasourceMapper;
    @Resource
    private DsmDatasourceTypeMapper dsmDatasourceTypeMapper;
    @Resource
    private DsmDatasetService dsmDatasetService;

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

    @Override
    public List<DsmDataset> datasetSource(DatasetSourceReqVO datasetSourceReqVO) {
        DsmDatasourceType dsmDatasourceType = dsmDatasourceTypeMapper.selectByPrimaryKey(datasetSourceReqVO.getDatasourceType());
        Connection connection= DBUtil.getConnection(datasetSourceReqVO,dsmDatasourceType);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DsmDataset> sourceList = new ArrayList<>();
        List<DsmDataset> endList = new ArrayList<>();
        if(connection!=null){
            try {
                String sql="";
                if(dsmDatasourceType.getDriverClass().contains("dm")||dsmDatasourceType.getDriverClass().contains("oracle")){
                    /**
                     * 达梦数据库和ORCALE数据库
                     */
                    sql="SELECT OWNER,TABLE_NAME,TABLE_TYPE,COMMENTS FROM ALL_TAB_COMMENTS WHERE OWNER = ? AND TABLE_NAME LIKE CONCAT('%', ?, '%') ORDER BY TABLE_TYPE,TABLE_NAME";
                    ps = connection.prepareStatement(sql);
                    if(datasetSourceReqVO.getSchemaName() == null || datasetSourceReqVO.getSchemaName().equals("")){
                        ps.setString(1, datasetSourceReqVO.getUsername());
                    }else {
                        ps.setString(1,datasetSourceReqVO.getSchemaName());
                    }
                    ps.setString(2,datasetSourceReqVO.getTableName());

                }else if(dsmDatasourceType.getDriverClass().contains("mysql")){
                    /**
                     * Mysql数据库
                     */
                    sql="SELECT TABLE_NAME,TABLE_TYPE,TABLE_COMMENT COMMENTS FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME LIKE CONCAT('%', ?, '%') ORDER BY TABLE_TYPE,TABLE_NAME";
                    ps = connection.prepareStatement(sql);
                    if(datasetSourceReqVO.getSchemaName() == null || datasetSourceReqVO.getSchemaName().equals("")){
                        ps.setString(1, datasetSourceReqVO.getUsername());
                    }else {
                        ps.setString(1,datasetSourceReqVO.getSchemaName());
                    }
                    ps.setString(2,datasetSourceReqVO.getTableName() == null ? "" : datasetSourceReqVO.getTableName());
                }else if(dsmDatasourceType.getDriverClass().contains("sqlserver")){
                    /**
                     * sqlserver数据库
                     */
                    sql="";
                }
                //调用executeQuery（）方法，返回一个结果集rs,到此，数据库查询数据的工作就完成了
                rs = ps.executeQuery();
                while(rs.next()) {
                    DsmDataset dsmDataset = new DsmDataset();
                    dsmDataset.setDatasetName(rs.getString("TABLE_NAME"));
                    dsmDataset.setDatasetType(rs.getString("TABLE_TYPE"));
                    dsmDataset.setDatasetComment(rs.getString("COMMENTS"));
                    dsmDataset.setSchemaName(datasetSourceReqVO.getSchemaName());
                    dsmDataset.setDatasourceId(datasetSourceReqVO.getDatasourceId());
                    sourceList.add(dsmDataset);
                }
                List<DsmDataset> targetList = dsmDatasetService.selectByDatasourceId(datasetSourceReqVO.getDatasourceId());
                if(targetList.size()>0){
                    endList = sourceList.stream().filter(m -> !targetList.stream().map(d -> d.getDatasetName()).collect(Collectors.toList()).contains(m.getDatasetName())).collect(Collectors.toList());
                    return endList;
                }
                //如果已经采集取差集，即只显示未采集的数据集对象
            } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();
            }finally {
                DBUtil.close(connection,ps,rs);
            }
            return sourceList;
        }else{
            return null;
        }
    }

}
