package com.heb.guitar.vo.profession.req;

import com.heb.guitar.entity.DsmDatasource;

public class DatasetSourceReqVO extends DsmDatasource {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
