package com.faas.core.base.model.db.operation.details.dao;

import java.util.List;

public class AutomationExecute {

    private String automationId;
    private String automation;
    private String automationType;
    private String automationBaseType;
    private List<ExecuteValue> executeValues;
    private long cDate;
    private int status;

    public AutomationExecute() {
    }

    public AutomationExecute(String automationId, String automation, String automationType, String automationBaseType, List<ExecuteValue> executeValues, long cDate, int status) {
        this.automationId = automationId;
        this.automation = automation;
        this.automationType = automationType;
        this.automationBaseType = automationBaseType;
        this.executeValues = executeValues;
        this.cDate = cDate;
        this.status = status;
    }

    public String getAutomationId() {
        return automationId;
    }

    public void setAutomationId(String automationId) {
        this.automationId = automationId;
    }

    public String getAutomation() {
        return automation;
    }

    public void setAutomation(String automation) {
        this.automation = automation;
    }

    public String getAutomationType() {
        return automationType;
    }

    public void setAutomationType(String automationType) {
        this.automationType = automationType;
    }

    public String getAutomationBaseType() {
        return automationBaseType;
    }

    public void setAutomationBaseType(String automationBaseType) {
        this.automationBaseType = automationBaseType;
    }

    public List<ExecuteValue> getExecuteValues() {
        return executeValues;
    }

    public void setExecuteValues(List<ExecuteValue> executeValues) {
        this.executeValues = executeValues;
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
