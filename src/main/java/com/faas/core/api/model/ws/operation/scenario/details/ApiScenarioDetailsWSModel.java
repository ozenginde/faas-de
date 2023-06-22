package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioDetailsWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioDetailsWSDTO>scenarioDetails;

    public ApiScenarioDetailsWSModel() {
    }

    public ApiScenarioDetailsWSModel(GeneralWSModel general, List<ApiScenarioDetailsWSDTO> scenarioDetails) {
        this.general = general;
        this.scenarioDetails = scenarioDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioDetailsWSDTO> getScenarioDetails() {
        return scenarioDetails;
    }

    public void setScenarioDetails(List<ApiScenarioDetailsWSDTO> scenarioDetails) {
        this.scenarioDetails = scenarioDetails;
    }
}
