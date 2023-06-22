package com.faas.core.base.model.ws.scenario.element.automation.content.dto;

import com.faas.core.base.model.db.scenario.element.automation.AutomationElementDBModel;

public class AutomationElementWSDTO {

    private AutomationElementDBModel automationElement;

    public AutomationElementWSDTO() {
    }

    public AutomationElementWSDTO(AutomationElementDBModel automationElement) {
        this.automationElement = automationElement;
    }

    public AutomationElementDBModel getAutomationElement() {
        return automationElement;
    }

    public void setAutomationElement(AutomationElementDBModel automationElement) {
        this.automationElement = automationElement;
    }
}
