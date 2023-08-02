package com.faas.core.api.model.ws.operation.scenario.execution;

import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiExecutionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiExecutionWSModel {

    private GeneralWSModel general;
    private List<ApiExecutionWSDTO>scenarioExecutions;

    public ApiExecutionWSModel() {
    }

    public ApiExecutionWSModel(GeneralWSModel general, List<ApiExecutionWSDTO> scenarioExecutions) {
        this.general = general;
        this.scenarioExecutions = scenarioExecutions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiExecutionWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ApiExecutionWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
