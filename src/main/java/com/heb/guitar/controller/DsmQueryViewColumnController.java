package com.heb.guitar.controller;


import com.heb.guitar.entity.DsmQueryViewColumn;
import com.heb.guitar.service.DsmQueryViewColumnService;
import com.heb.guitar.utils.DataResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @PostMapping("/queryViewsColumn")
    public DataResult add(@RequestBody DsmQueryViewColumn dsmQueryViewColumn){
        DataResult result= DataResult.success();
        result.setData(dsmQueryViewColumnService.insert(dsmQueryViewColumn));
        return result;
    }

    @PutMapping("/queryViewsColumn")
    public DataResult update(@RequestBody @Valid DsmQueryViewColumn dsmQueryViewColumn
            , HttpServletRequest request){
        DataResult result= DataResult.success();
        result.setData(dsmQueryViewColumnService.update(dsmQueryViewColumn));
        return DataResult.success();
    }



}
