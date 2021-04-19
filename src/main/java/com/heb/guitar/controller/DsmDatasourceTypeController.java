package com.heb.guitar.controller;

import com.heb.guitar.entity.DsmDatasourceType;
import com.heb.guitar.service.DsmDatasourceTypeService;
import com.heb.guitar.utils.DataResult;
import com.heb.guitar.vo.profession.req.DataTypeVO;
import com.heb.guitar.vo.req.RoleUpdateReqVO;
import com.heb.guitar.vo.resp.PageVO;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DsmDatasourceTypeController {

    @Resource
    private DsmDatasourceTypeService dsmDatasourceTypeService;

    @PostMapping("/datasourceTypes")
    public DataResult pageInfo(@RequestBody DataTypeVO vo){
        DataResult result= DataResult.success();
        PageVO pageVO = new PageVO();
        pageVO.setTotalRows(dsmDatasourceTypeService.dataTypeCount(vo));
        pageVO.setList(dsmDatasourceTypeService.selectAll(vo));
        result.setData(pageVO);
        return result;
    }

    @DeleteMapping("/datasourceTypes/{id}")
    public DataResult deleted(@PathVariable("id") String id){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceTypeService.deleted(id));
        return result;
    }

    @PostMapping("/datasourceType")
    public DataResult add(@RequestBody DsmDatasourceType dsmDatasourceType){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceTypeService.insert(dsmDatasourceType));
        return result;
    }

    @PutMapping("/datasourceType")
    public DataResult updateRole(@RequestBody @Valid DsmDatasourceType dsmDatasourceType
                                                            , HttpServletRequest request){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceTypeService.update(dsmDatasourceType,request));
        return DataResult.success();
    }

}
