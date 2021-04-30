package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmQueryView;
import com.heb.guitar.mapper.DsmQueryViewMapper;
import com.heb.guitar.service.DsmQueryViewService;
import com.heb.guitar.vo.profession.req.QueryViewReqVO;
import com.heb.guitar.vo.profession.resp.QueryViewRespVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;


@Service
public class DsmQueryViewServiceImpl implements DsmQueryViewService {

    @Resource
    private DsmQueryViewMapper dsmQueryViewMapper;

    @Override
    public int insertSelective(DsmQueryView record) {
        record.setViewId(UUID.randomUUID().toString());
        return dsmQueryViewMapper.insertSelective(record);
    }

    @Override
    public List<QueryViewRespVO> selectAll(QueryViewReqVO queryViewReqVO) {
        return dsmQueryViewMapper.selectAll(queryViewReqVO);
    }

    @Override
    public long queryViewCount(QueryViewReqVO queryViewReqVO) {
        return dsmQueryViewMapper.queryViewCount(queryViewReqVO);
    }


}
