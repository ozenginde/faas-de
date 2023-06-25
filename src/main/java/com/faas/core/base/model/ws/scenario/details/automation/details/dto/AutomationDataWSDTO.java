package com.faas.core.base.model.ws.scenario.details.automation.details.dto;

import com.faas.core.base.model.db.scenario.details.automation.dao.AutomationDataDAO;

public class AutomationDataWSDTO {

    private AutomationDataDAO automationData;

    public AutomationDataWSDTO() {
    }

    public AutomationDataWSDTO(AutomationDataDAO automationData) {
        this.automationData = automationData;
    }

    public AutomationDataDAO getAutomationData() {
        return automationData;
    }

    public void setAutomationData(AutomationDataDAO automationData) {
        this.automationData = automationData;
    }
}
