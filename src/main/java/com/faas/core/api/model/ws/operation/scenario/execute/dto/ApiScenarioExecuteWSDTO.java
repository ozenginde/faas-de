package com.faas.core.api.model.ws.operation.scenario.execute.dto;

import com.faas.core.base.model.db.operation.scenario.ScenarioExecuteDBModel;

public class ApiScenarioExecuteWSDTO {

    private ScenarioExecuteDBModel scenarioExecute;

    public ApiScenarioExecuteWSDTO() {
    }

    public ApiScenarioExecuteWSDTO(ScenarioExecuteDBModel scenarioExecute) {
        this.scenarioExecute = scenarioExecute;
    }

    public ScenarioExecuteDBModel getScenarioExecute() {
        return scenarioExecute;
    }

    public void setScenarioExecute(ScenarioExecuteDBModel scenarioExecute) {
        this.scenarioExecute = scenarioExecute;
    }
}
