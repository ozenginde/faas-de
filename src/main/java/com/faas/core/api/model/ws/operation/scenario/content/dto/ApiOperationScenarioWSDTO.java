package com.faas.core.api.model.ws.operation.scenario.content.dto;


import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiExecutionWSDTO;

import java.util.List;

public class ApiOperationScenarioWSDTO {

    private List<ApiScenarioWSDTO> scenarios;
    private List<ApiExecutionWSDTO> scenarioExecutions;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(List<ApiScenarioWSDTO> scenarios, List<ApiExecutionWSDTO> scenarioExecutions) {
        this.scenarios = scenarios;
        this.scenarioExecutions = scenarioExecutions;
    }

    public List<ApiScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }

    public List<ApiExecutionWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ApiExecutionWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
