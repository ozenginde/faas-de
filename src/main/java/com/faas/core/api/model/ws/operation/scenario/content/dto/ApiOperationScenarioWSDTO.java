package com.faas.core.api.model.ws.operation.scenario.content.dto;


import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiScenarioExecutionWSDTO;

import java.util.List;

public class ApiOperationScenarioWSDTO {

    private List<ApiScenarioWSDTO> scenarios;
    private List<ApiScenarioExecutionWSDTO> executions;

    public ApiOperationScenarioWSDTO() {
    }

    public ApiOperationScenarioWSDTO(List<ApiScenarioWSDTO> scenarios, List<ApiScenarioExecutionWSDTO> executions) {
        this.scenarios = scenarios;
        this.executions = executions;
    }

    public List<ApiScenarioWSDTO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ApiScenarioWSDTO> scenarios) {
        this.scenarios = scenarios;
    }

    public List<ApiScenarioExecutionWSDTO> getExecutions() {
        return executions;
    }

    public void setExecutions(List<ApiScenarioExecutionWSDTO> executions) {
        this.executions = executions;
    }
}
