package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmColumn;
import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.mapper.DsmColumnMapper;
import com.heb.guitar.mapper.DsmDatasetMapper;
import com.heb.guitar.mapper.DsmDatasourceMapper;
import com.heb.guitar.mapper.DsmDatasourceTypeMapper;
import com.heb.guitar.service.DsmColumnService;
import com.heb.guitar.service.DsmDatasetService;
import com.heb.guitar.utils.DBUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class DsmColumnServiceImpl implements DsmColumnService {

    @Resource
    private DsmColumnMapper dsmColumnMapper;
    @Resource
    private DsmDatasetMapper dsmDatasetMapper;
    @Resource
    private DsmDatasourceMapper dsmDatasourceMapper;
    @Resource
    private DsmDatasourceTypeMapper dsmDatasourceTypeMapper;

    @Override
    public List<DsmColumn> selectByDatasetId(DsmColumn dsmColumn) {
        return dsmColumnMapper.selectByDatasetId(dsmColumn);
    }

    @Override
    public int syncColumns(DsmColumn dsmColumn) {
        DsmDataset dsmDataset = dsmDatasetMapper.selectByPrimaryKey(dsmColumn.getDatasetId());
        DsmDatasource dsmDatasource = dsmDatasourceMapper.selectByPrimaryKey(dsmDataset.getDatasourceId());
        DsmDatasourceType dsmDatasourceType = dsmDatasourceTypeMapper.selectByPrimaryKey(dsmDatasource.getDatasourceType());
        Connection connection= DBUtil.getConnection(dsmDatasource,dsmDatasourceType);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DsmColumn> list = new ArrayList<>();
        if(connection!=null){
            try {
                String sql = "";
                if (dsmDatasourceType.getDriverClass().contains("dm") || dsmDatasourceType.getDriverClass().contains("oracle")) {
                    /**
                     * 达梦数据库和ORCALE数据库
                     */
                    sql = "SELECT A.OWNER,A.TABLE_NAME,A.COLUMN_NAME,A.DATA_TYPE,A.DATA_LENGTH,A.DATA_SCALE,A.NULLABLE,B.COMMENTS FROM ALL_TAB_COLUMNS A,ALL_COL_COMMENTS B WHERE " +
                            "A.OWNER = B.OWNER AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME AND A.OWNER = ? AND A.TABLE_NAME = ? ";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1,dsmDataset.getSchemaName());
                    ps.setString(2,dsmDataset.getDatasetName());
                }else if(dsmDatasourceType.getDriverClass().contains("mysql")){
                    /**
                     * Mysql数据库
                     */
                    sql="SELECT COLUMN_NAME,COLUMN_TYPE DATA_TYPE,COLUMN_TYPE,COLUMN_COMMENT COMMENTS,IS_NULLABLE NULLABLE,NUMERIC_PRECISION DATA_LENGTH,NUMERIC_SCALE DATA_SCALE" +
                            " FROM INFORMATION_SCHEMA.COLUMNS WHERE " +
                            "TABLE_SCHEMA = ? AND TABLE_NAME = ?";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1,dsmDataset.getSchemaName());
                    ps.setString(2,dsmDataset.getDatasetName());
                }

                //调用executeQuery（）方法，返回一个结果集rs,到此，数据库查询数据的工作就完成了
                rs = ps.executeQuery();
                while(rs.next()) {
                    DsmColumn ds = new DsmColumn();
                    ds.setColumnId(UUID.randomUUID().toString());
                    ds.setDatasetId(dsmDataset.getDatasetId());
                    ds.setColumnName(rs.getString("COLUMN_NAME"));
                    ds.setColumnComment(rs.getString("COMMENTS"));
                    ds.setDataType(rs.getString("DATA_TYPE"));
                    ds.setLength(rs.getString("DATA_LENGTH") == null ? null : Integer.parseInt(rs.getString("DATA_LENGTH")));
                    ds.setScale(rs.getString("DATA_SCALE") == null ? null : Integer.parseInt(rs.getString("DATA_SCALE")));
                    ds.setIsNullable(rs.getString("NULLABLE"));
                    ds.setUpdateTime(new Date());
                    list.add(ds);
                }
                int delNum = dsmColumnMapper.deleteByDatasetId(dsmDataset.getDatasetId());
                return dsmColumnMapper.batchSave(list);
            }catch (SQLException e){
                e.getMessage();
                e.printStackTrace();
            }finally {
                DBUtil.close(connection,ps,rs);
            }
        }else {
            return -1;
        }
        return 0;
    }

    @Override
    public int batchDeleteColumns(List<DsmColumn> list) {
        return dsmColumnMapper.batchDeleteColumns(list);
    }
}
