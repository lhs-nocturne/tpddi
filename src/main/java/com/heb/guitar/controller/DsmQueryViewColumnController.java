package com.heb.guitar.controller;

import com.heb.guitar.entity.DsmQueryViewColumn;
import com.heb.guitar.service.DsmQueryViewColumnService;
import com.heb.guitar.utils.DataResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DsmQueryViewColumnController {

    @Resource
    private DsmQueryViewColumnService dsmQueryViewColumnService;

    @PostMapping("/queryViewsColumns")
    public DataResult queryViewsColumns(@RequestBody DsmQueryViewColumn dsmQueryViewColumn){
        DataResult result= DataResult.success();
        result.setData(dsmQueryViewColumnService.listByViewId(dsmQueryViewColumn));
        return result;
    }

    @PostMapping("/batchDeleteViewColumns")
    public DataResult batchDeleteViewColumns(@RequestBody List<DsmQueryViewColumn> list){
        DataResult result= DataResult.success();
        int num = dsmQueryViewColumnService.batchDeleteViewColumns(list);
        result.setData(num);
        return result;
    }

}
