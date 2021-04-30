package com.heb.guitar.service.impl;

import com.heb.guitar.entity.DsmQueryViewColumn;
import com.heb.guitar.mapper.DsmQueryViewColumnMapper;
import com.heb.guitar.service.DsmQueryViewColumnService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class DsmQueryViewColumnServiceImpl implements DsmQueryViewColumnService {

    @Resource
    private DsmQueryViewColumnMapper dsmQueryViewColumnMapper;

    @Override
    public List<DsmQueryViewColumn> listByViewId(DsmQueryViewColumn dsmQueryViewColumn) {
        return dsmQueryViewColumnMapper.listByViewId(dsmQueryViewColumn);
    }

    @Override
    public int batchSave(List<DsmQueryViewColumn> list) {
        return dsmQueryViewColumnMapper.batchSave(list);
    }

    @Override
    public int batchDeleteViewColumns(List<DsmQueryViewColumn> list) {
        return dsmQueryViewColumnMapper.batchDeleteViewColumns(list);
    }

}
