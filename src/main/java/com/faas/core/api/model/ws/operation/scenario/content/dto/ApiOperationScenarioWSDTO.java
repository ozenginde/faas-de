package com.faas.core.api.model.ws.operation.scenario.content.dto;


import com.faas.core.api.model.ws.operation.scenario.execute.dto.ApiScenarioExecuteWSDTO;

import java.util.List;

public class ApiOperationScenarioWSDTO {

    private List<ApiScenarioWSDTO> scenarios;
    private List<ApiScenarioExecuteWSDTO> scenarioExecutions;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(List<ApiScenarioWSDTO> scenarios, List<ApiScenarioExecuteWSDTO> scenarioExecutions) {
        this.scenarios = scenarios;
        this.scenarioExecutions = scenarioExecutions;
    }

    public List<ApiScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }

    public List<ApiScenarioExecuteWSDTO> getScenarioExecutions() {
        return scenarioExecutions;
    }

    public void setScenarioExecutions(List<ApiScenarioExecuteWSDTO> scenarioExecutions) {
        this.scenarioExecutions = scenarioExecutions;
    }
}
