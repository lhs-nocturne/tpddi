package com.heb.guitar.service.impl;

import com.heb.guitar.constants.Constant;
import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.mapper.DsmDatasourceTypeMapper;
import com.heb.guitar.service.DsmDatasourceTypeService;
import com.heb.guitar.utils.JwtTokenUtil;
import com.heb.guitar.vo.profession.req.DataTypeVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DsmDatasourceTypeServiceImpl implements DsmDatasourceTypeService {

    @Resource
    private DsmDatasourceTypeMapper dsmDatasourceTypeMapper;

    @Override
    public List<DsmDatasourceType> selectAll(DataTypeVO vo) {
        return dsmDatasourceTypeMapper.selectAll(vo);
    }

    @Override
    public long dataTypeCount(DataTypeVO vo) {
        return dsmDatasourceTypeMapper.dataTypeCount(vo);
    }

    @Override
    public int deleted(String id) {
        return dsmDatasourceTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DsmDatasourceType dsmDatasourceType) {
        dsmDatasourceType.setTypeId(UUID.randomUUID().toString());
        return dsmDatasourceTypeMapper.insertSelective(dsmDatasourceType);
    }

    @Override
    public int update(DsmDatasourceType dsmDatasourceType, HttpServletRequest request) {
        String token = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(token);
        dsmDatasourceType.setUpdateUser(userId);
        dsmDatasourceType.setUpdateTime(new Date());
        return dsmDatasourceTypeMapper.updateByPrimaryKeySelective(dsmDatasourceType);
    }

    @Override
    public DsmDatasourceType getByPrimaryKey(String typeId) {
        return dsmDatasourceTypeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public DsmDatasourceType selectByPrimaryKey(String typeId) {
        return dsmDatasourceTypeMapper.selectByPrimaryKey(typeId);
    }


}
