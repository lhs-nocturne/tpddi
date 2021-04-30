package com.heb.guitar.entity;

import java.io.Serializable;
import java.util.Date;

public class DsmQueryViewColumn implements Serializable {
    private String columnId;

    private String viewId;

    private String columnName;

    private String columnComment;

    private String dataType;

    private String dataFormat;

    private String displayFormat;

    private String dictionaryId;

    private Integer isResult;

    private Integer isQuery;

    private Integer conditionType;

    private Integer conditionRequired;

    private Integer orderType;

    private Integer sortNum;

    private String note;

    private String memo1;

    private String memo2;

    private String updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId == null ? null : viewId.trim();
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
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

    public String getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId == null ? null : dictionaryId.trim();
    }

    public Integer getIsResult() {
        return isResult;
    }

    public void setIsResult(Integer isResult) {
        this.isResult = isResult;
    }

    public Integer getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(Integer isQuery) {
        this.isQuery = isQuery;
    }

    public Integer getConditionType() {
        return conditionType;
    }

    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }

    public Integer getConditionRequired() {
        return conditionRequired;
    }

    public void setConditionRequired(Integer conditionRequired) {
        this.conditionRequired = conditionRequired;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", columnId=").append(columnId);
        sb.append(", viewId=").append(viewId);
        sb.append(", columnName=").append(columnName);
        sb.append(", columnComment=").append(columnComment);
        sb.append(", dataType=").append(dataType);
        sb.append(", dataFormat=").append(dataFormat);
        sb.append(", displayFormat=").append(displayFormat);
        sb.append(", dictionaryId=").append(dictionaryId);
        sb.append(", isResult=").append(isResult);
        sb.append(", isQuery=").append(isQuery);
        sb.append(", conditionType=").append(conditionType);
        sb.append(", conditionRequired=").append(conditionRequired);
        sb.append(", orderType=").append(orderType);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", note=").append(note);
        sb.append(", memo1=").append(memo1);
        sb.append(", memo2=").append(memo2);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}