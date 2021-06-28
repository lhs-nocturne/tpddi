package com.heb.guitar.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.heb.guitar.constants.Constant;
import com.heb.guitar.entity.*;
import com.heb.guitar.mapper.DsmColumnMapper;
import com.heb.guitar.mapper.DsmDatasetMapper;
import com.heb.guitar.mapper.DsmQueryViewColumnMapper;
import com.heb.guitar.mapper.DsmQueryViewMapper;
import com.heb.guitar.service.DsmDatasourceService;
import com.heb.guitar.service.DsmDatasourceTypeService;
import com.heb.guitar.service.DsmQueryViewService;
import com.heb.guitar.service.RedisService;
import com.heb.guitar.vo.profession.req.QueryViewReqVO;
import com.heb.guitar.vo.profession.resp.QueryViewRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class DsmQueryViewServiceImpl implements DsmQueryViewService {

    @Resource
    private DsmQueryViewMapper dsmQueryViewMapper;
    @Resource
    private DsmQueryViewColumnMapper dsmQueryViewColumnMapper;
    @Resource
    private DsmColumnMapper dsmColumnMapper;
    @Resource
    private DsmDatasetMapper dsmDatasetMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private DsmDatasourceService dsmDatasourceService;
    @Resource
    private DsmDatasourceTypeService dsmDatasourceTypeService;

    @Override
    public int insertSelective(DsmQueryView record) {
        String uuid = UUID.randomUUID().toString();
        record.setViewId(uuid);
        int num = dsmQueryViewMapper.insertSelective(record);
        if(num>0){
            DsmColumn dsmColumn = new DsmColumn();
            dsmColumn.setDatasetId(record.getDatasetId());
            List<DsmColumn> list = dsmColumnMapper.selectByDatasetId(dsmColumn);
            List<DsmQueryViewColumn> vcList =  new ArrayList<>();
            int i = 1;
            for(DsmColumn dsmColumn1 : list){
                DsmQueryViewColumn dsmQueryViewColumn = new DsmQueryViewColumn();
                dsmQueryViewColumn.setColumnId(UUID.randomUUID().toString());
                dsmQueryViewColumn.setColumnName(dsmColumn1.getColumnName());
                dsmQueryViewColumn.setColumnComment(dsmColumn1.getColumnComment());
                dsmQueryViewColumn.setViewId(uuid);
                dsmQueryViewColumn.setDataType(dsmColumn1.getDataType());
                dsmQueryViewColumn.setUpdateTime(new Date());
                dsmQueryViewColumn.setSortNum(i++);
                dsmQueryViewColumn.setIsResult(1);
                dsmQueryViewColumn.setIsQuery(0);
                vcList.add(dsmQueryViewColumn);
            }
            if(vcList.size()>0){
                dsmQueryViewColumnMapper.batchSave(vcList);
            }
        }
        /**
         * 将视图详细信息存入redis
         */
        DsmDatasource dsmDatasource = dsmDatasourceService.selectByPrimaryKey(record.getDatasourceId());
        DsmDatasourceType dsmDatasourceType = dsmDatasourceTypeService.selectByPrimaryKey(dsmDatasource.getDatasourceType());
        ViewDetail viewDetail = new ViewDetail();
        viewDetail.setDsmQueryView(record);
        viewDetail.setDsmDatasource(dsmDatasource);
        viewDetail.setDsmDatasourceType(dsmDatasourceType);
        redisService.set(Constant.VIEW_DETAIL+uuid,viewDetail);
        return num;
    }

    @Override
    public List<QueryViewRespVO> selectAll(QueryViewReqVO queryViewReqVO) {
        return dsmQueryViewMapper.selectAll(queryViewReqVO);
    }

    @Override
    public long queryViewCount(QueryViewReqVO queryViewReqVO) {
        return dsmQueryViewMapper.queryViewCount(queryViewReqVO);
    }

    @Override
    public int updateByPrimaryKeySelective(DsmQueryView record) {
        int count =  dsmQueryViewMapper.updateByPrimaryKeySelective(record);
        if(count>0){
            redisService.delete(Constant.VIEW_DETAIL+record.getViewId());
            DsmDatasource dsmDatasource = dsmDatasourceService.selectByPrimaryKey(record.getDatasourceId());
            DsmDatasourceType dsmDatasourceType = dsmDatasourceTypeService.selectByPrimaryKey(dsmDatasource.getDatasourceType());
            ViewDetail viewDetail = new ViewDetail();
            viewDetail.setDsmQueryView(record);
            viewDetail.setDsmDatasource(dsmDatasource);
            viewDetail.setDsmDatasourceType(dsmDatasourceType);
            redisService.set(Constant.VIEW_DETAIL+record.getViewId(),viewDetail);
        }
        return count;
    }

    @Override
    public int deleteByPrimaryKey(String viewId) {
        int i = 0;
        if(dsmQueryViewMapper.deleteByPrimaryKey(viewId)>0){
            i = dsmQueryViewColumnMapper.deleteByViewId(viewId);
        }
        redisService.delete(Constant.VIEW_DETAIL+viewId);
        return i;
    }

    @Override
    public int makeSql(DsmQueryView record) {
        DsmQueryViewColumn dsmQueryViewColumn = new DsmQueryViewColumn();
        dsmQueryViewColumn.setViewId(record.getViewId());
        List<DsmQueryViewColumn> columnList = dsmQueryViewColumnMapper.listByViewId(dsmQueryViewColumn);
        DsmDataset dsmDataset = dsmDatasetMapper.selectByPrimaryKey(record.getDatasetId());
        StringBuffer selectBuffer = new StringBuffer();
        StringBuffer whereBuffer = new StringBuffer();
        if(columnList != null){
            int i = 0;
            selectBuffer.append("SELECT ");
            //whereBuffer.append(" WHERE 1=1 ");
            for(DsmQueryViewColumn column : columnList){
                if(column.getIsResult() == 1){
                    selectBuffer.append(column.getColumnName());
                    selectBuffer.append(",");
                }
                if(column.getIsQuery() == 1){
                    if(i>0){
                        whereBuffer.append(" AND ");
                    }
                    whereBuffer.append(column.getColumnName());
                    if(StringUtils.isEmpty(column.getConditionType())){
                        //如果类型是空的就默认等于
                        whereBuffer.append(" = :");
                        whereBuffer.append(column.getColumnName());
                    }else {
                        //精确查询
                        if(column.getConditionType().equals("equal")){
                            whereBuffer.append(" = :");
                            whereBuffer.append(column.getColumnName());
                        }
                        //模糊查询
                        if(column.getConditionType().equals("like")){
                            whereBuffer.append(" LIKE CONCAT('%', :");
                            whereBuffer.append(column.getColumnName());
                            whereBuffer.append(" ,'%')");
                        }
                    }
                    i++;
                }
            }
            selectBuffer.deleteCharAt(selectBuffer.length()-1);
            selectBuffer.append(" FROM ");
            selectBuffer.append(dsmDataset.getDatasetName());
            if(i>0){
                selectBuffer.append(" WHERE ");
            }
            selectBuffer.append(whereBuffer);
        }
        log.info("=****************************=SQL拼接={}",selectBuffer.toString());
        record.setQuerySql(selectBuffer.toString());
        return dsmQueryViewMapper.updateByPrimaryKeySelective(record);
    }




}
