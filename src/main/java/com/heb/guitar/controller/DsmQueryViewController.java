package com.heb.guitar.controller;


import com.heb.guitar.entity.DsmDatasource;
import com.heb.guitar.entity.DsmQueryView;
import com.heb.guitar.service.DsmQueryViewService;
import com.heb.guitar.utils.DataResult;
import com.heb.guitar.vo.profession.req.DataSourceReqVO;
import com.heb.guitar.vo.profession.req.QueryViewReqVO;
import com.heb.guitar.vo.resp.PageVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
@RequestMapping("/api")
public class DsmQueryViewController {

    @Resource
    private DsmQueryViewService dsmQueryViewService;

    @PostMapping("/queryViews")
    public DataResult pageInfo(@RequestBody QueryViewReqVO vo){
        DataResult result= DataResult.success();
        PageVO pageVO = new PageVO();
        pageVO.setTotalRows(dsmQueryViewService.queryViewCount(vo));
        pageVO.setList(dsmQueryViewService.selectAll(vo));
        result.setData(pageVO);
        return result;
    }

    @PostMapping("/queryView")
    public DataResult add(@RequestBody DsmQueryView dsmQueryView){
        DataResult result= DataResult.success();
        result.setData(dsmQueryViewService.insertSelective(dsmQueryView));
        return result;
    }

}
