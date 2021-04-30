package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmColumn;
import com.heb.guitar.entity.DsmQueryView;
import com.heb.guitar.entity.DsmQueryViewColumn;
import com.heb.guitar.mapper.DsmColumnMapper;
import com.heb.guitar.mapper.DsmQueryViewColumnMapper;
import com.heb.guitar.mapper.DsmQueryViewMapper;
import com.heb.guitar.service.DsmQueryViewService;
import com.heb.guitar.vo.profession.req.QueryViewReqVO;
import com.heb.guitar.vo.profession.resp.QueryViewRespVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class DsmQueryViewServiceImpl implements DsmQueryViewService {

    @Resource
    private DsmQueryViewMapper dsmQueryViewMapper;
    @Resource
    private DsmQueryViewColumnMapper dsmQueryViewColumnMapper;
    @Resource
    private DsmColumnMapper dsmColumnMapper;

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
                vcList.add(dsmQueryViewColumn);
            }
            dsmQueryViewColumnMapper.batchSave(vcList);
        }
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
        return dsmQueryViewMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String viewId) {
        return dsmQueryViewMapper.deleteByPrimaryKey(viewId);
    }


}
