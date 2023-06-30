package com.faas.core.base.model.ws.scenario.details.content.dto;

import com.faas.core.base.model.ws.scenario.details.action.content.dto.ActionWSDTO;
import com.faas.core.base.model.ws.scenario.details.automation.content.dto.AutomationWSDTO;

public class ScenarioElementWSDTO {

    private ActionWSDTO actionElement;
    private AutomationWSDTO automationElement;

    public ScenarioElementWSDTO() {
    }

    public ScenarioElementWSDTO(ActionWSDTO actionElement, AutomationWSDTO automationElement) {
        this.actionElement = actionElement;
        this.automationElement = automationElement;
    }

    public ActionWSDTO getActionElement() {
        return actionElement;
    }

    public void setActionElement(ActionWSDTO actionElement) {
        this.actionElement = actionElement;
    }

    public AutomationWSDTO getAutomationElement() {
        return automationElement;
    }

    public void setAutomationElement(AutomationWSDTO automationElement) {
        this.automationElement = automationElement;
    }
}
