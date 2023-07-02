package com.faas.core.base.model.ws.process.details.scenario.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ProcessScenarioWSDTO {

    private ProcessScenarioDBModel scenario;
    public ScenarioDBModel scenarioDetails;

    public ProcessScenarioWSDTO() {
    }

    public ProcessScenarioWSDTO(ProcessScenarioDBModel scenario, ScenarioDBModel scenarioDetails) {
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
