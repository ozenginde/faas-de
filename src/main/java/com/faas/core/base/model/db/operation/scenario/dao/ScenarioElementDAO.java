package com.faas.core.base.model.db.operation.scenario.dao;


public class ScenarioElementDAO {

    private AutomationExecuteDAO automationExecute;
    private ActionExecuteDAO actionExecute;

    public ScenarioElementDAO() {
    }

    public ScenarioElementDAO(AutomationExecuteDAO automationExecute, ActionExecuteDAO actionExecute) {
        this.automationExecute = automationExecute;
        this.actionExecute = actionExecute;
    }

    public AutomationExecuteDAO getAutomationExecute() {
        return automationExecute;
    }

    public void setAutomationExecute(AutomationExecuteDAO automationExecute) {
        this.automationExecute = automationExecute;
    }

    public ActionExecuteDAO getActionExecute() {
        return actionExecute;
    }

    public void setActionExecute(ActionExecuteDAO actionExecute) {
        this.actionExecute = actionExecute;
    }
}
