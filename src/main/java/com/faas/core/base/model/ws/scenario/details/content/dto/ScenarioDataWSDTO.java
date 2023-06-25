package com.faas.core.base.model.ws.scenario.details.content.dto;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;

public class ScenarioDataWSDTO {

    private ScenarioDataDAO scenarioData;

    public ScenarioDataWSDTO() {
    }

    public ScenarioDataWSDTO(ScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }

    public ScenarioDataDAO getScenarioData() {
        return scenarioData;
    }

    public void setScenarioData(ScenarioDataDAO scenarioData) {
        this.scenarioData = scenarioData;
    }
}
