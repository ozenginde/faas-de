package com.faas.core.api.model.ws.operation.details.scenario.execution.dto;

import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;

public class ApiScenarioExecutionWSDTO {

    private ScenarioExecutionDBModel scenarioExecution;

    public ApiScenarioExecutionWSDTO() {
    }

    public ApiScenarioExecutionWSDTO(ScenarioExecutionDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }

    public ScenarioExecutionDBModel getScenarioExecution() {
        return scenarioExecution;
    }

    public void setScenarioExecution(ScenarioExecutionDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }
}
