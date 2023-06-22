package com.faas.core.base.model.ws.scenario.details.dto;

import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionElementWSDTO;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationElementWSDTO;

import java.util.List;

public class ScenarioElementWSDTO {

    private List<ActionElementWSDTO> actionElements;
    private List<AutomationElementWSDTO>automationElements;

    public ScenarioElementWSDTO() {
    }

    public ScenarioElementWSDTO(List<ActionElementWSDTO> actionElements, List<AutomationElementWSDTO> automationElements) {
        this.actionElements = actionElements;
        this.automationElements = automationElements;
    }

    public List<ActionElementWSDTO> getActionElements() {
        return actionElements;
    }

    public void setActionElements(List<ActionElementWSDTO> actionElements) {
        this.actionElements = actionElements;
    }

    public List<AutomationElementWSDTO> getAutomationElements() {
        return automationElements;
    }

    public void setAutomationElements(List<AutomationElementWSDTO> automationElements) {
        this.automationElements = automationElements;
    }
}
