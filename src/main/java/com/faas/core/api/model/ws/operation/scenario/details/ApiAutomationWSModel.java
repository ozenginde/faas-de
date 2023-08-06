package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiAutomationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiAutomationWSModel {

    private GeneralWSModel general;
    private List<ApiAutomationWSDTO>scenarioAutomations;

    public ApiAutomationWSModel() {
    }

    public ApiAutomationWSModel(GeneralWSModel general, List<ApiAutomationWSDTO> scenarioAutomations) {
        this.general = general;
        this.scenarioAutomations = scenarioAutomations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiAutomationWSDTO> getScenarioAutomations() {
        return scenarioAutomations;
    }

    public void setScenarioAutomations(List<ApiAutomationWSDTO> scenarioAutomations) {
        this.scenarioAutomations = scenarioAutomations;
    }
}
