package com.heb.guitar.entity;

import java.io.Serializable;
import java.util.Date;

public class DsmDataset implements Serializable {
    private String datasetId;

    private String nodeCode;

    private String datasourceId;

    private String schemaName;

    private String datasetName;

    private String datasetComment;

    private String datasetLabel;

    private String datasetType;

    private Long recordCount;

    private Long increaseCount;

    private Date countTime;

    private Integer securityLevel;

    private Integer sortNum;

    private String note;

    private String memo1;

    private String memo2;

    private String updateUser;

    private Date updateTime;

    private String bizStartTime;

    private String bizEndTime;

    private String type;

    private static final long serialVersionUID = 1L;

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId == null ? null : datasetId.trim();
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId == null ? null : datasourceId.trim();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName == null ? null : datasetName.trim();
    }

    public String getDatasetComment() {
        return datasetComment;
    }

    public void setDatasetComment(String datasetComment) {
        this.datasetComment = datasetComment == null ? null : datasetComment.trim();
    }

    public String getDatasetLabel() {
        return datasetLabel;
    }

    public void setDatasetLabel(String datasetLabel) {
        this.datasetLabel = datasetLabel == null ? null : datasetLabel.trim();
    }

    public String getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = datasetType == null ? null : datasetType.trim();
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public Long getIncreaseCount() {
        return increaseCount;
    }

    public void setIncreaseCount(Long increaseCount) {
        this.increaseCount = increaseCount;
    }

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1 == null ? null : memo1.trim();
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2 == null ? null : memo2.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBizStartTime() {
        return bizStartTime;
    }

    public void setBizStartTime(String bizStartTime) {
        this.bizStartTime = bizStartTime == null ? null : bizStartTime.trim();
    }

    public String getBizEndTime() {
        return bizEndTime;
    }

    public void setBizEndTime(String bizEndTime) {
        this.bizEndTime = bizEndTime == null ? null : bizEndTime.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", datasetId=").append(datasetId);
        sb.append(", nodeCode=").append(nodeCode);
        sb.append(", datasourceId=").append(datasourceId);
        sb.append(", schemaName=").append(schemaName);
        sb.append(", datasetName=").append(datasetName);
        sb.append(", datasetComment=").append(datasetComment);
        sb.append(", datasetLabel=").append(datasetLabel);
        sb.append(", datasetType=").append(datasetType);
        sb.append(", recordCount=").append(recordCount);
        sb.append(", increaseCount=").append(increaseCount);
        sb.append(", countTime=").append(countTime);
        sb.append(", securityLevel=").append(securityLevel);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", note=").append(note);
        sb.append(", memo1=").append(memo1);
        sb.append(", memo2=").append(memo2);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", bizStartTime=").append(bizStartTime);
        sb.append(", bizEndTime=").append(bizEndTime);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}