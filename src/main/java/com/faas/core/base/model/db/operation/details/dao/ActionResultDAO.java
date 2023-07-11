package com.faas.core.base.model.db.operation.details.dao;

import java.util.List;

public class ActionResultDAO {

    private String id;
    private String actionId;
    private String action;
    private List<ExecutionDataDAO> executionDatas;
    private long cDate;
    private int status;

    public ActionResultDAO() {
    }

    public ActionResultDAO(String id, String actionId, String action, List<ExecutionDataDAO> executionDatas, long cDate, int status) {
        this.id = id;
        this.actionId = actionId;
        this.action = action;
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
