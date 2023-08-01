package com.faas.core.api.model.ws.operation.scenario.content.dto;


import com.faas.core.api.model.ws.operation.scenario.execute.dto.ApiScenarioExecuteWSDTO;

import java.util.List;

public class ApiOperationScenarioWSDTO {

    private List<ApiScenarioWSDTO> scenarios;
    private List<ApiScenarioExecuteWSDTO> scenarioExecutes;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(List<ApiScenarioWSDTO> scenarios, List<ApiScenarioExecuteWSDTO> scenarioExecutes) {
        this.scenarios = scenarios;
        this.scenarioExecutes = scenarioExecutes;
    }

    public List<ApiScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }

    public List<ApiScenarioExecuteWSDTO> getScenarioExecutes() {
        return scenarioExecutes;
    }

    public void setScenarioExecutes(List<ApiScenarioExecuteWSDTO> scenarioExecutes) {
        this.scenarioExecutes = scenarioExecutes;
    }
}
