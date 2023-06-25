package com.faas.core.base.model.ws.scenario.element.automation.details.dto;

import com.faas.core.base.model.db.scenario.element.automation.dao.AutomationVariableDAO;

public class AutomationVariableWSDTO {

    private AutomationVariableDAO automationVariable;

    public AutomationVariableWSDTO() {
    }

    public AutomationVariableWSDTO(AutomationVariableDAO automationVariable) {
        this.automationVariable = automationVariable;
    }

    public AutomationVariableDAO getAutomationVariable() {
        return automationVariable;
    }

    public void setAutomationVariable(AutomationVariableDAO automationVariable) {
        this.automationVariable = automationVariable;
    }
}
