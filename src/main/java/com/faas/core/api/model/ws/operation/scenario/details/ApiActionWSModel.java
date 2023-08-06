package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiActionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiActionWSModel {

    private GeneralWSModel general;
    private List<ApiActionWSDTO>scenarioActions;

    public ApiActionWSModel() {
    }

    public ApiActionWSModel(GeneralWSModel general, List<ApiActionWSDTO> scenarioActions) {
        this.general = general;
        this.scenarioActions = scenarioActions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiActionWSDTO> getScenarioActions() {
        return scenarioActions;
    }

    public void setScenarioActions(List<ApiActionWSDTO> scenarioActions) {
        this.scenarioActions = scenarioActions;
    }
}
