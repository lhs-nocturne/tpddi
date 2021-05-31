package com.heb.guitar.service;

import com.heb.guitar.entity.DsmQueryView;
import com.heb.guitar.vo.profession.req.QueryViewReqVO;
import com.heb.guitar.vo.profession.resp.QueryViewRespVO;
import java.util.List;

public interface DsmQueryViewService {

    int insertSelective(DsmQueryView record);

    List<QueryViewRespVO> selectAll(QueryViewReqVO queryViewReqVO);

    long queryViewCount(QueryViewReqVO queryViewReqVO);

    int updateByPrimaryKeySelective(DsmQueryView record);

    int deleteByPrimaryKey(String viewId);

    int makeSql(DsmQueryView record);
}
