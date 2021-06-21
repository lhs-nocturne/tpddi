package com.heb.guitar.mapper;

import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.vo.profession.req.DataTypeVO;
import java.util.List;

public interface DsmDatasourceTypeMapper {
    int deleteByPrimaryKey(String typeId);

    int insert(DsmDatasourceType record);

    int insertSelective(DsmDatasourceType record);

    DsmDatasourceType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(DsmDatasourceType record);

    int updateByPrimaryKey(DsmDatasourceType record);

    List<DsmDatasourceType> selectAll(DataTypeVO vo);

    long dataTypeCount(DataTypeVO vo);

    List<DsmDatasourceType> all();

    long isUse(String typeId);

}