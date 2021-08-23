package com.santechture.update_fetch_service.model;

import java.util.List;

public class JsonTableObject {
    private String tableName;
    private String auditName;
    private List<String> cols;
    private String colRef;
    private String colValue;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public String getColRef() {
        return colRef;
    }

    public void setColRef(String colRef) {
        this.colRef = colRef;
    }

    public String getColValue() {
        return colValue;
    }

    public void setColValue(String colValue) {
        this.colValue = colValue;
    }
}
