package com.faas.core.base.model.db.operation.scenario.dao;

import java.util.List;

public class ActionExecuteDAO {

    private String executeId;
    private List<ScenarioExecuteDataDAO> executeDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ActionExecuteDAO() {
    }

    public ActionExecuteDAO(String executeId, List<ScenarioExecuteDataDAO> executeDatas, long uDate, long cDate, int status) {
        this.executeId = executeId;
        this.executeDatas = executeDatas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getExecuteId() {
        return executeId;
    }

    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    public List<ScenarioExecuteDataDAO> getExecuteDatas() {
        return executeDatas;
    }

    public void setExecuteDatas(List<ScenarioExecuteDataDAO> executeDatas) {
        this.executeDatas = executeDatas;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
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
