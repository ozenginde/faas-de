package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiAutomationElementWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiAutomationElementWSModel {

    private GeneralWSModel general;
    private List<ApiAutomationElementWSDTO>automationElements;

    public ApiAutomationElementWSModel() {
    }

    public ApiAutomationElementWSModel(GeneralWSModel general, List<ApiAutomationElementWSDTO> automationElements) {
        this.general = general;
        this.automationElements = automationElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiAutomationElementWSDTO> getAutomationElements() {
        return automationElements;
    }

    public void setAutomationElements(List<ApiAutomationElementWSDTO> automationElements) {
        this.automationElements = automationElements;
    }
}
