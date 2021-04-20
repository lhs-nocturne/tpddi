package com.heb.guitar.entity;

import java.io.Serializable;
import java.util.Date;

public class DsmDatasource implements Serializable {
    private String datasourceId;

    private String nodeCode;

    private String datasourceType;

    private String datasourceName;

    private Integer datasourceClassify;

    private String host;

    private String port;

    private String username;

    private String password;

    private String databaseName;

    private String schemaName;

    private String jdbcUrl;

    private Integer initialSize;

    private Integer minIdle;

    private Integer maxIdle;

    private Integer maxActive;

    private Integer maxWait;

    private Integer autoConnect;

    private Integer poolPrepared;

    private Integer status;

    private Integer securityLevel;

    private Integer sortNum;

    private String note;

    private String memo1;

    private String memo2;

    private String updateUser;

    private Date updateTime;

    private String fzdw;

    private String fzr;

    private String lxfs;

    private static final long serialVersionUID = 1L;

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId == null ? null : datasourceId.trim();
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType == null ? null : datasourceType.trim();
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName == null ? null : datasourceName.trim();
    }

    public Integer getDatasourceClassify() {
        return datasourceClassify;
    }

    public void setDatasourceClassify(Integer datasourceClassify) {
        this.datasourceClassify = datasourceClassify;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName == null ? null : databaseName.trim();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl == null ? null : jdbcUrl.trim();
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getAutoConnect() {
        return autoConnect;
    }

    public void setAutoConnect(Integer autoConnect) {
        this.autoConnect = autoConnect;
    }

    public Integer getPoolPrepared() {
        return poolPrepared;
    }

    public void setPoolPrepared(Integer poolPrepared) {
        this.poolPrepared = poolPrepared;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getFzdw() {
        return fzdw;
    }

    public void setFzdw(String fzdw) {
        this.fzdw = fzdw == null ? null : fzdw.trim();
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr == null ? null : fzr.trim();
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs == null ? null : lxfs.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", datasourceId=").append(datasourceId);
        sb.append(", nodeCode=").append(nodeCode);
        sb.append(", datasourceType=").append(datasourceType);
        sb.append(", datasourceName=").append(datasourceName);
        sb.append(", datasourceClassify=").append(datasourceClassify);
        sb.append(", host=").append(host);
        sb.append(", port=").append(port);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", databaseName=").append(databaseName);
        sb.append(", schemaName=").append(schemaName);
        sb.append(", jdbcUrl=").append(jdbcUrl);
        sb.append(", initialSize=").append(initialSize);
        sb.append(", minIdle=").append(minIdle);
        sb.append(", maxIdle=").append(maxIdle);
        sb.append(", maxActive=").append(maxActive);
        sb.append(", maxWait=").append(maxWait);
        sb.append(", autoConnect=").append(autoConnect);
        sb.append(", poolPrepared=").append(poolPrepared);
        sb.append(", status=").append(status);
        sb.append(", securityLevel=").append(securityLevel);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", note=").append(note);
        sb.append(", memo1=").append(memo1);
        sb.append(", memo2=").append(memo2);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", fzdw=").append(fzdw);
        sb.append(", fzr=").append(fzr);
        sb.append(", lxfs=").append(lxfs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}