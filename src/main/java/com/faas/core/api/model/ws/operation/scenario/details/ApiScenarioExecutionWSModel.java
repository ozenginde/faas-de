package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiScenarioExecutionWSModel {

    private GeneralWSModel general;
    private List<ApiScenarioExecutionWSDTO>scenarioExecutions;

    public ApiScenarioExecutionWSModel() {
    }

    public ApiScenarioExecutionWSModel(GeneralWSModel general, List<ApiScenarioExecutionWSDTO> scenarioExecutions) {
        this.general = general;
        this.scenarioExecutions = scenarioExecutions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiScenarioExecutionWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ApiScenarioExecutionWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
