package com.heb.guitar.controller;

import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.mapper.DsmDatasourceTypeMapper;
import com.heb.guitar.service.DsmDatasourceService;
import com.heb.guitar.utils.DataResult;
import com.heb.guitar.vo.profession.req.DataSourceReqVO;
import com.heb.guitar.vo.profession.req.DatasetSourceReqVO;
import com.heb.guitar.vo.resp.PageVO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DsmDatasourceController {

    @Resource
    private DsmDatasourceService dsmDatasourceService;
    @Resource
    private DsmDatasourceTypeMapper dsmDatasourceTypeMapper;

    @PostMapping("/datasources")
    public DataResult pageInfo(@RequestBody DataSourceReqVO vo){
        DataResult result= DataResult.success();
        PageVO pageVO = new PageVO();
        pageVO.setTotalRows(dsmDatasourceService.datasourceCount(vo));
        pageVO.setList(dsmDatasourceService.selectAll(vo));
        result.setData(pageVO);
        return result;
    }

    @PostMapping("/datasource")
    public DataResult add(@RequestBody DsmDatasource dsmDatasource){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceService.insertSelective(dsmDatasource));
        return result;
    }

    @PostMapping("/dataTypeSelect")
    public DataResult typeList(){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceTypeMapper.all());
        return result;
    }

    @DeleteMapping("/datasource/{id}")
    public DataResult deleted(@PathVariable("id") String id){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceService.deleteByPrimaryKey(id));
        return result;
    }

    @PutMapping("/datasource")
    public DataResult update(@RequestBody @Valid DsmDatasource dsmDatasource
            , HttpServletRequest request){
        DataResult result= DataResult.success();
        result.setData(dsmDatasourceService.updateByPrimaryKeySelective(dsmDatasource));
        return DataResult.success();
    }

    @PostMapping("/testConnect")
    public DataResult testConnect(@RequestBody DsmDatasource dsmDatasource){
        boolean status = dsmDatasourceService.testConnect(dsmDatasource);
        DataResult result= status == true ? DataResult.getResult(0,"连接成功！") :
                DataResult.getResult(0,"连接失败。");
        return result;
    }

    @PostMapping("/datasetSource")
    public DataResult datasetSource(@RequestBody DatasetSourceReqVO datasetSourceReqVO){
        List<DsmDataset> list= dsmDatasourceService.datasetSource(datasetSourceReqVO);
        DataResult result= DataResult.getResult(list);
        return result;
    }

    @PostMapping("/datasourceSelect")
    public DataResult datasourceSelect(@RequestBody DsmDatasource dsmDatasource){
        List<DsmDatasource> list= dsmDatasourceService.datasourceSelect(dsmDatasource);
        DataResult result= DataResult.getResult(list);
        return result;
    }

}
