package com.heb.guitar.service;

import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.vo.profession.req.DataTypeVO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DsmDatasourceTypeService {

    List<DsmDatasourceType> selectAll(DataTypeVO vo);

    long dataTypeCount(DataTypeVO vo);

    int deleted(String id);

    int insert(DsmDatasourceType dsmDatasourceType);

    int update(DsmDatasourceType dsmDatasourceType, HttpServletRequest request);
}
