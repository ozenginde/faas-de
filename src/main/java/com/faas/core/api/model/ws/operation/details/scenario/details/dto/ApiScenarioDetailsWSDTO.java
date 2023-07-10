package com.faas.core.api.model.ws.operation.details.scenario.details.dto;

import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.details.action.ActionDBModel;
import com.faas.core.base.model.db.scenario.details.automation.AutomationDBModel;

import java.util.List;

public class ApiScenarioDetailsWSDTO {

    private ProcessScenarioDBModel scenario;
    private ScenarioDBModel scenarioDetails;
    private List<ActionDBModel> actions;
    private List<AutomationDBModel> automations;

    public ApiScenarioDetailsWSDTO() {
    }

    public ApiScenarioDetailsWSDTO(ProcessScenarioDBModel scenario, ScenarioDBModel scenarioDetails, List<ActionDBModel> actions, List<AutomationDBModel> automations) {
        this.scenario = scenario;
        this.scenarioDetails = scenarioDetails;
        this.actions = actions;
        this.automations = automations;
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

    public List<ActionDBModel> getActions() {
        return actions;
    }

    public void setActions(List<ActionDBModel> actions) {
        this.actions = actions;
    }

    public List<AutomationDBModel> getAutomations() {
        return automations;
    }

    public void setAutomations(List<AutomationDBModel> automations) {
        this.automations = automations;
    }
}
