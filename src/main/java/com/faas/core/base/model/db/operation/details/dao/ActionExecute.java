package com.faas.core.base.model.db.operation.details.dao;

import java.util.List;

public class ActionExecute {

    private String actionId;
    private String action;
    private List<ExecuteValue> executeValues;
    private long cDate;
    private int status;

    public ActionExecute() {
    }

    public ActionExecute(String actionId, String action, List<ExecuteValue> executeValues, long cDate, int status) {
        this.actionId = actionId;
        this.action = action;
        this.executeValues = executeValues;
        this.cDate = cDate;
        this.status = status;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
