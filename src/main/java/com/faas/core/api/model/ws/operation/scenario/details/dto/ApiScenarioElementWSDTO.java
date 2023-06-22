package com.faas.core.api.model.ws.operation.scenario.details.dto;

import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionElementWSDTO;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationElementWSDTO;

public class ApiScenarioElementWSDTO {

    private ActionElementWSDTO actionElement;
    private AutomationElementWSDTO automationElement;

    public ApiScenarioElementWSDTO() {
    }

    public ApiScenarioElementWSDTO(ActionElementWSDTO actionElement, AutomationElementWSDTO automationElement) {
        this.actionElement = actionElement;
        this.automationElement = automationElement;
    }

    public ActionElementWSDTO getActionElement() {
        return actionElement;
    }

    public void setActionElement(ActionElementWSDTO actionElement) {
        this.actionElement = actionElement;
    }

    public AutomationElementWSDTO getAutomationElement() {
        return automationElement;
    }

    public void setAutomationElement(AutomationElementWSDTO automationElement) {
        this.automationElement = automationElement;
    }
}
