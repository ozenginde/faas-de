package com.faas.core.base.model.ws.scenario.element.automation.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.dto.AutomationVariableWSDTO;

import java.util.List;

public class AutomationVariableWSModel {

    private GeneralWSModel general;
    private List<AutomationVariableWSDTO>automationVariables;

    public AutomationVariableWSModel() {
    }

    public AutomationVariableWSModel(GeneralWSModel general, List<AutomationVariableWSDTO> automationVariables) {
        this.general = general;
        this.automationVariables = automationVariables;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationVariableWSDTO> getAutomationVariables() {
        return automationVariables;
    }

    public void setAutomationVariables(List<AutomationVariableWSDTO> automationVariables) {
        this.automationVariables = automationVariables;
    }
}

