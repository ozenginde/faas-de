package com.faas.core.base.model.ws.scenario.details.automation.content.dto;

import com.faas.core.base.model.db.scenario.details.automation.AutomationDBModel;

public class AutomationWSDTO {

    private AutomationDBModel automation;

    public AutomationWSDTO() {
    }

    public AutomationWSDTO(AutomationDBModel automation) {
        this.automation = automation;
    }

    public AutomationDBModel getAutomation() {
        return automation;
    }

    public void setAutomation(AutomationDBModel automation) {
        this.automation = automation;
    }
}
