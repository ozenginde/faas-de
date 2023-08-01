package com.faas.core.base.model.db.operation.details.dao;


public class ScenarioExecute {

    private String id;
    private String executeType;
    private ActionExecute actionExecute;
    private AutomationExecute automationExecute;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioExecute() {
    }

    public ScenarioExecute(String id, String executeType, ActionExecute actionExecute, AutomationExecute automationExecute, long uDate, long cDate, int status) {
        this.id = id;
        this.executeType = executeType;
        this.actionExecute = actionExecute;
        this.automationExecute = automationExecute;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExecuteType() {
        return executeType;
    }

    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }

    public ActionExecute getActionExecute() {
        return actionExecute;
    }

    public void setActionExecute(ActionExecute actionExecute) {
        this.actionExecute = actionExecute;
    }

    public AutomationExecute getAutomationExecute() {
        return automationExecute;
    }

    public void setAutomationExecute(AutomationExecute automationExecute) {
        this.automationExecute = automationExecute;
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
