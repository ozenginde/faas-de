package com.faas.core.base.model.db.operation.details.dao;


public class ExecutionResultDAO {

    private ActionResultDAO actionResult;
    private AutomationResultDAO automationResult;

    public ExecutionResultDAO() {
    }

    public ExecutionResultDAO(ActionResultDAO actionResult, AutomationResultDAO automationResult) {
        this.actionResult = actionResult;
        this.automationResult = automationResult;
    }

    public ActionResultDAO getActionResult() {
        return actionResult;
    }

    public void setActionResult(ActionResultDAO actionResult) {
        this.actionResult = actionResult;
    }

    public AutomationResultDAO getAutomationResult() {
        return automationResult;
    }

    public void setAutomationResult(AutomationResultDAO automationResult) {
        this.automationResult = automationResult;
    }
}
