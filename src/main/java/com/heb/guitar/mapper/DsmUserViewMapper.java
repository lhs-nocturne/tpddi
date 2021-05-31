package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmUserView;

import java.util.List;

public interface DsmUserViewMapper {
    int deleteByPrimaryKey(String id);

    int insert(DsmUserView record);

    int insertSelective(DsmUserView record);

    DsmUserView selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DsmUserView record);

    int updateByPrimaryKey(DsmUserView record);

    List<String> getViewByUserId(String userId);

    int removeByUserId(String userId);

    int batchUserView(List<DsmUserView> list);
}