package com.faas.core.base.model.ws.process.details.scenario.dto;

import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioVariableDAO;

public class ProcessScenarioVariableWSDTO {

    private ProcessScenarioVariableDAO scenarioVariable;

    public ProcessScenarioVariableWSDTO() {
    }

    public ProcessScenarioVariableWSDTO(ProcessScenarioVariableDAO scenarioVariable) {
        this.scenarioVariable = scenarioVariable;
    }

    public ProcessScenarioVariableDAO getScenarioVariable() {
        return scenarioVariable;
    }

    public void setScenarioVariable(ProcessScenarioVariableDAO scenarioVariable) {
        this.scenarioVariable = scenarioVariable;
    }
}
