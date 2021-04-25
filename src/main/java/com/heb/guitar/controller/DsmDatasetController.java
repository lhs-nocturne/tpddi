package com.heb.guitar.controller;

import com.heb.guitar.entity.DsmDataset;
import com.heb.guitar.service.DsmDatasetService;
import com.heb.guitar.utils.DataResult;
import com.heb.guitar.vo.profession.req.DatasetReqVO;
import com.heb.guitar.vo.resp.PageVO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DsmDatasetController {

    @Resource
    private DsmDatasetService dsmDatasetService;

    @PostMapping("/selectByDatasource")
    public DataResult selectByDatasource(@RequestBody DsmDataset dsmDataset){
        DataResult result= DataResult.success();
        result.setData(dsmDatasetService.selectByDatasource(dsmDataset));
        return result;
    }

    @PostMapping("/collectDataset")
    public DataResult collectDataset(@RequestBody List<DsmDataset> dsmDataset){
        int num = dsmDatasetService.batchSave(dsmDataset);
        DataResult result= DataResult.success(num);
        return result;
    }

    @PostMapping("/datasets")
    public DataResult pageInfo(@RequestBody DatasetReqVO vo){
        DataResult result= DataResult.success();
        PageVO pageVO = new PageVO();
        pageVO.setTotalRows(dsmDatasetService.datasetCount(vo));
        pageVO.setList(dsmDatasetService.selectAll(vo));
        result.setData(pageVO);
        return result;
    }

    @PutMapping("/dataset")
    public DataResult update(@RequestBody @Valid DsmDataset dsmDataset
            , HttpServletRequest request){
        DataResult result= DataResult.success();
        result.setData(dsmDatasetService.updateByPrimaryKeySelective(dsmDataset));
        return DataResult.success();
    }

    @DeleteMapping("/dataset/{id}")
    public DataResult deleted(@PathVariable("id") String id){
        DataResult result= DataResult.success();
        result.setData(dsmDatasetService.deleteByPrimaryKey(id));
        return result;
    }

}
