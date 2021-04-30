package com.heb.guitar.vo.profession.resp;

import com.heb.guitar.entity.DsmQueryView;

public class QueryViewRespVO extends DsmQueryView {

    private String datasetName;

    private String datasourceName;

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }
}
