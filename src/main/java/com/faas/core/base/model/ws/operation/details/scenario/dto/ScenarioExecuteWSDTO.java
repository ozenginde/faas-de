package com.faas.core.base.model.ws.operation.details.scenario.dto;

import com.faas.core.base.model.db.operation.details.ScenarioExecuteDBModel;

public class ScenarioExecuteWSDTO {

    private ScenarioExecuteDBModel scenarioExecute;

    public ScenarioExecuteWSDTO() {
    }

    public ScenarioExecuteWSDTO(ScenarioExecuteDBModel scenarioExecute) {
        this.scenarioExecute = scenarioExecute;
    }

    public ScenarioExecuteDBModel getScenarioExecute() {
        return scenarioExecute;
    }

    public void setScenarioExecute(ScenarioExecuteDBModel scenarioExecute) {
        this.scenarioExecute = scenarioExecute;
    }
}
