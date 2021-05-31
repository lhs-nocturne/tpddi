package com.heb.guitar.controller;

import com.alibaba.fastjson.JSONObject;
import com.heb.guitar.constants.Constant;
import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.entity.DsmQueryView;
import com.heb.guitar.entity.RSEntity;
import com.heb.guitar.exception.BusinessException;
import com.heb.guitar.exception.code.BaseResponseCode;
import com.heb.guitar.mapper.DsmDatasourceMapper;
import com.heb.guitar.mapper.DsmDatasourceTypeMapper;
import com.heb.guitar.mapper.DsmQueryViewMapper;
import com.heb.guitar.service.RedisService;
import com.heb.guitar.utils.DBRouteUtil;
import com.heb.guitar.utils.DataResult;
import com.heb.guitar.utils.JwtTokenUtil;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Resource
    private DsmQueryViewMapper dsmQueryViewMapper;
    @Resource
    private DsmDatasourceMapper dsmDatasourceMapper;
    @Resource
    private DsmDatasourceTypeMapper dsmDatasourceTypeMapper;
    @Resource
    private RedisService redisService;

    @PostMapping("/terminalDataServer")
    public DataResult terminalDataServer(@RequestBody RSEntity rsEntity, HttpServletRequest request){
        DsmQueryView dsmQueryView = dsmQueryViewMapper.selectByPrimaryKey(rsEntity.getViewId());
        String userId= JwtTokenUtil.getUserId(request.getHeader(Constant.ACCESS_TOKEN));
        /**
         * 去redis查看是都拥有视图权限，先从redis查看
         */
        if(redisService.hasKey(Constant.USER_VIEW_KEY+userId)){
            List<String> viewList = JSONObject.parseArray(redisService.get(Constant.USER_VIEW_KEY+userId).toString(),String.class);
            if(!viewList.contains(rsEntity.getViewId())){
                throw new BusinessException(BaseResponseCode.NO_USER_VIEW);
            }
        }else{
           //若redis内没有从数据库查

        }
        if(dsmQueryView.getStatus() == 0){
            throw new BusinessException(BaseResponseCode.STOP_SERVER);
        }
        /*if(redisService.hasKey(Constant.VIEW_DETAIL+rsEntity.getViewId())){
            JSONObject viewDetilString =  JSONObject.parseObject(redisService.get(Constant.VIEW_DETAIL+rsEntity.getViewId()).toString());
            JSONObject  data = JSONObject.parseObject(viewDetilString.getString("data"));
        }*/
        DsmDatasource dsmDatasource = dsmDatasourceMapper.selectByPrimaryKey(dsmQueryView.getDatasourceId());
        DsmDatasourceType dsmDatasourceType = dsmDatasourceTypeMapper.selectByPrimaryKey(dsmDatasource.getDatasourceType());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = DBRouteUtil.getJdbcTemplate(dsmDatasource,dsmDatasourceType);
        Map params = (Map) rsEntity.getParams();
        List list = namedParameterJdbcTemplate.queryForList(dsmQueryView.getQuerySql(),params);
        DataResult result= DataResult.success();
        result.setData(list);
        return result;
    }


}
