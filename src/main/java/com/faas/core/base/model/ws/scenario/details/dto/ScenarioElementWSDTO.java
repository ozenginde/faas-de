package com.faas.core.base.model.ws.scenario.details.dto;

import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionWSDTO;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationWSDTO;

public class ScenarioElementWSDTO {

    private ActionWSDTO action;
    private AutomationWSDTO automation;

    public ScenarioElementWSDTO() {
    }

    public ScenarioElementWSDTO(ActionWSDTO action, AutomationWSDTO automation) {
        this.action = action;
        this.automation = automation;
    }

    public ActionWSDTO getAction() {
        return action;
    }

    public void setAction(ActionWSDTO action) {
        this.action = action;
    }

    public AutomationWSDTO getAutomation() {
        return automation;
    }

    public void setAutomation(AutomationWSDTO automation) {
        this.automation = automation;
    }
}
