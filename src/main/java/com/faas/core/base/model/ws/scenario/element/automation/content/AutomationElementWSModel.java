package com.faas.core.base.model.ws.scenario.element.automation.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationElementWSDTO;

import java.util.List;

public class AutomationElementWSModel {

    private GeneralWSModel general;
    private List<AutomationElementWSDTO>automationElements;

    public AutomationElementWSModel() {
    }

    public AutomationElementWSModel(GeneralWSModel general, List<AutomationElementWSDTO> automationElements) {
        this.general = general;
        this.automationElements = automationElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationElementWSDTO> getAutomationElements() {
        return automationElements;
    }

    public void setAutomationElements(List<AutomationElementWSDTO> automationElements) {
        this.automationElements = automationElements;
    }
}
