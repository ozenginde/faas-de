package com.faas.core.api.model.ws.operation.scenario.content;

import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioActionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioActionWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioActionWSDTO>scenarioActions;

    public ApiScenarioActionWSModel() {
    }

    public ApiScenarioActionWSModel(GeneralWSModel general, List<ApiScenarioActionWSDTO> scenarioActions) {
        this.general = general;
        this.scenarioActions = scenarioActions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioActionWSDTO> getScenarioActions() {
        return scenarioActions;
    }

    public void setScenarioActions(List<ApiScenarioActionWSDTO> scenarioActions) {
        this.scenarioActions = scenarioActions;
    }
}
