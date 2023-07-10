package com.faas.core.api.model.ws.operation.details.scenario.details;

import com.faas.core.api.model.ws.operation.details.scenario.details.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiScenarioDetailsWSModel {

    private GeneralWSModel general;
    private ApiScenarioDetailsWSDTO scenarioDetails;

    public ApiScenarioDetailsWSModel() {
    }

    public ApiScenarioDetailsWSModel(GeneralWSModel general, ApiScenarioDetailsWSDTO scenarioDetails) {
        this.general = general;
        this.scenarioDetails = scenarioDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiScenarioDetailsWSDTO getScenarioDetails() {
        return scenarioDetails;
    }

    public void setScenarioDetails(ApiScenarioDetailsWSDTO scenarioDetails) {
        this.scenarioDetails = scenarioDetails;
    }
}
