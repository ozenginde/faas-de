package com.faas.core.api.model.ws.operation.details.scenario.execution.dto;

import com.faas.core.api.model.ws.operation.details.scenario.content.dto.ApiScenarioWSDTO;
import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;

public class ApiScenarioExecutionWSDTO {

    private ApiScenarioWSDTO scenario;
    private ScenarioExecutionDBModel scenarioExecution;

    public ApiScenarioExecutionWSDTO() {
    }

    public ApiScenarioExecutionWSDTO(ApiScenarioWSDTO scenario, ScenarioExecutionDBModel scenarioExecution) {
        this.scenario = scenario;
        this.scenarioExecution = scenarioExecution;
    }

    public ApiScenarioWSDTO getScenario() {
        return scenario;
    }

    public void setScenario(ApiScenarioWSDTO scenario) {
        this.scenario = scenario;
    }

    public ScenarioExecutionDBModel getScenarioExecution() {
        return scenarioExecution;
    }

    public void setScenarioExecution(ScenarioExecutionDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }
}
