package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioAutomationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioAutomationWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioAutomationWSDTO>scenarioAutomations;

    public ApiScenarioAutomationWSModel() {
    }

    public ApiScenarioAutomationWSModel(GeneralWSModel general, List<ApiScenarioAutomationWSDTO> scenarioAutomations) {
        this.general = general;
        this.scenarioAutomations = scenarioAutomations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioAutomationWSDTO> getScenarioAutomations() {
        return scenarioAutomations;
    }

    public void setScenarioAutomations(List<ApiScenarioAutomationWSDTO> scenarioAutomations) {
        this.scenarioAutomations = scenarioAutomations;
    }
}
