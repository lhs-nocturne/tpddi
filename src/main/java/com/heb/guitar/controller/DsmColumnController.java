package com.heb.guitar.controller;


import com.heb.guitar.entity.DsmColumn;
import com.heb.guitar.service.DsmColumnService;
import com.heb.guitar.utils.DataResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DsmColumnController {

    @Resource
    private DsmColumnService dsmColumnService;

    @PostMapping("/selectByDatasetId")
    public DataResult selectByDatasetId(@RequestBody DsmColumn DsmColumn){
        DataResult result= DataResult.success();
        result.setData(dsmColumnService.selectByDatasetId(DsmColumn));
        return result;
    }

    @PostMapping("/syncColumns")
    public DataResult syncColumns(@RequestBody DsmColumn dsmColumn){
        DataResult result= DataResult.success();
        int num = dsmColumnService.syncColumns(dsmColumn);
        result.setMsg(num<0 ? "数据源连接失败" : "操作成功");
        result.setData(num);
        return result;
    }

    @PostMapping("/batchDeleteColumns")
    public DataResult batchDeleteColumns(@RequestBody List<DsmColumn> list){
        DataResult result= DataResult.success();
        result.setData(dsmColumnService.batchDeleteColumns(list));
        return result;
    }

}
