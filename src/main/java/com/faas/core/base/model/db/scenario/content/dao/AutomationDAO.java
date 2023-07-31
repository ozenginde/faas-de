package com.faas.core.base.model.db.scenario.content.dao;


public class AutomationDAO {

    private long tempId;
    private String automationTemp;
    private long typeId;
    private String automationType;
    private String baseType;
    private long cDate;
    private int status;

    public AutomationDAO() {
    }

    public AutomationDAO(long tempId, String automationTemp, long typeId, String automationType, String baseType, long cDate, int status) {
        this.tempId = tempId;
        this.automationTemp = automationTemp;
        this.typeId = typeId;
        this.automationType = automationType;
        this.baseType = baseType;
        this.cDate = cDate;
        this.status = status;
    }

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public String getAutomationTemp() {
        return automationTemp;
    }

    public void setAutomationTemp(String automationTemp) {
        this.automationTemp = automationTemp;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getAutomationType() {
        return automationType;
    }

    public void setAutomationType(String automationType) {
        this.automationType = automationType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
