package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmQueryView;
import com.heb.guitar.vo.profession.req.QueryViewReqVO;
import com.heb.guitar.vo.profession.resp.QueryViewRespVO;
import java.util.List;

public interface DsmQueryViewMapper {
    int deleteByPrimaryKey(String viewId);

    int insert(DsmQueryView record);

    int insertSelective(DsmQueryView record);

    DsmQueryView selectByPrimaryKey(String viewId);

    int updateByPrimaryKeySelective(DsmQueryView record);

    int updateByPrimaryKey(DsmQueryView record);

    List<QueryViewRespVO> selectAll(QueryViewReqVO queryViewReqVO);

    long queryViewCount(QueryViewReqVO queryViewReqVO);

    List<DsmQueryView> selectAllViews();
}