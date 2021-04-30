package com.heb.guitar.service;

import com.heb.guitar.entity.DsmQueryViewColumn;

import java.util.List;

public interface DsmQueryViewColumnService {

    List<DsmQueryViewColumn> listByViewId(DsmQueryViewColumn dsmQueryViewColumn);

    int batchSave(List<DsmQueryViewColumn> list);

    int batchDeleteViewColumns(List<DsmQueryViewColumn> list);

}
