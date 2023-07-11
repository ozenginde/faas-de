package com.faas.core.base.model.db.operation.details.dao;


import java.util.List;

public class AutomationResultDAO {

    private String id;
    private String automationId;
    private String automation;
    private List<ExecutionDataDAO> executionDatas;
    private long cDate;
    private int status;

    public AutomationResultDAO() {
    }

    public AutomationResultDAO(String id, String automationId, String automation, List<ExecutionDataDAO> executionDatas, long cDate, int status) {
        this.id = id;
        this.automationId = automationId;
        this.automation = automation;
        this.executionDatas = executionDatas;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<ExecutionDataDAO> getExecutionDatas() {
        return executionDatas;
    }

    public void setExecutionDatas(List<ExecutionDataDAO> executionDatas) {
        this.executionDatas = executionDatas;
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
