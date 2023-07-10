package com.faas.core.base.model.ws.operation.details.scenario.dto;

import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;

public class ScenarioExecutionWSDTO {

    private ScenarioExecutionDBModel scenarioExecution;

    public ScenarioExecutionWSDTO() {
    }

    public ScenarioExecutionWSDTO(ScenarioExecutionDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }

    public ScenarioExecutionDBModel getScenarioExecution() {
        return scenarioExecution;
    }

    public void setScenarioExecution(ScenarioExecutionDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }
}
