package com.heb.guitar.vo.profession.resp;

import com.heb.guitar.entity.DsmDataset;

public class DatasetRespVO extends DsmDataset {

    private String datasourceName;

    private String host;

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
