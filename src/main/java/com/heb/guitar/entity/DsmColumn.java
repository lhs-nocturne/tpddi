package com.heb.guitar.entity;

import java.io.Serializable;
import java.util.Date;

public class DsmColumn implements Serializable {
    private String columnId;

    private String nodeCode;

    private String dictionaryId;

    private String datasetId;

    private String columnName;

    private String columnComment;

    private String columnLabel;

    private String dataType;

    private Integer length;

    private Integer scale;

    private String defaultValue;

    private String dataFormat;

    private String displayFormat;

    private String isNullable;

    private Integer isPk;

    private Integer isQuery;

    private Integer compareType;

    private Integer orderType;

    private Integer securityLevel;

    private Integer sortNum;

    private String note;

    private String memo1;

    private String memo2;

    private String updateUser;

    private Date updateTime;

    private Integer keyboardType;

    private static final long serialVersionUID = 1L;

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    public String getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId == null ? null : dictionaryId.trim();
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId == null ? null : datasetId.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment == null ? null : columnComment.trim();
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel == null ? null : columnLabel.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat == null ? null : dataFormat.trim();
    }

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat == null ? null : displayFormat.trim();
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable == null ? null : isNullable.trim();
    }

    public Integer getIsPk() {
        return isPk;
    }

    public void setIsPk(Integer isPk) {
        this.isPk = isPk;
    }

    public Integer getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(Integer isQuery) {
        this.isQuery = isQuery;
    }

    public Integer getCompareType() {
        return compareType;
    }

    public void setCompareType(Integer compareType) {
        this.compareType = compareType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    public Integer getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(Integer keyboardType) {
        this.keyboardType = keyboardType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", columnId=").append(columnId);
        sb.append(", nodeCode=").append(nodeCode);
        sb.append(", dictionaryId=").append(dictionaryId);
        sb.append(", datasetId=").append(datasetId);
        sb.append(", columnName=").append(columnName);
        sb.append(", columnComment=").append(columnComment);
        sb.append(", columnLabel=").append(columnLabel);
        sb.append(", dataType=").append(dataType);
        sb.append(", length=").append(length);
        sb.append(", scale=").append(scale);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", dataFormat=").append(dataFormat);
        sb.append(", displayFormat=").append(displayFormat);
        sb.append(", isNullable=").append(isNullable);
        sb.append(", isPk=").append(isPk);
        sb.append(", isQuery=").append(isQuery);
        sb.append(", compareType=").append(compareType);
        sb.append(", orderType=").append(orderType);
        sb.append(", securityLevel=").append(securityLevel);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", note=").append(note);
        sb.append(", memo1=").append(memo1);
        sb.append(", memo2=").append(memo2);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", keyboardType=").append(keyboardType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}