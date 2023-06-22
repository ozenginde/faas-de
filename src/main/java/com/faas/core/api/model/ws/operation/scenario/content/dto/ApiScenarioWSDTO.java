package com.faas.core.api.model.ws.operation.scenario.content.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ApiScenarioWSDTO {

    private ProcessScenarioDBModel scenario;
    private ScenarioDBModel scenarioDetails;

    public ApiScenarioWSDTO() {
    }

    public ApiScenarioWSDTO(ProcessScenarioDBModel scenario, ScenarioDBModel scenarioDetails) {
        this.scenario = scenario;
        this.scenarioDetails = scenarioDetails;
    }

    public ProcessScenarioDBModel getScenario() {
        return scenario;
    }

    public void setScenario(ProcessScenarioDBModel scenario) {
        this.scenario = scenario;
    }

    public ScenarioDBModel getScenarioDetails() {
        return scenarioDetails;
    }

    public void setScenarioDetails(ScenarioDBModel scenarioDetails) {
        this.scenarioDetails = scenarioDetails;
    }
}
