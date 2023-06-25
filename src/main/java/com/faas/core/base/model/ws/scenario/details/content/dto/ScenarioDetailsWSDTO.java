package com.faas.core.base.model.ws.scenario.details.content.dto;

import com.faas.core.base.model.ws.scenario.details.action.content.dto.ActionWSDTO;
import com.faas.core.base.model.ws.scenario.details.automation.content.dto.AutomationWSDTO;

import java.util.List;

public class ScenarioDetailsWSDTO {

    private List<ActionWSDTO> scenarioActions;
    private List<AutomationWSDTO>scenarioAutomations;

    public ScenarioDetailsWSDTO() {
    }

    public ScenarioDetailsWSDTO(List<ActionWSDTO> scenarioActions, List<AutomationWSDTO> scenarioAutomations) {
        this.scenarioActions = scenarioActions;
        this.scenarioAutomations = scenarioAutomations;
    }

    public List<ActionWSDTO> getScenarioActions() {
        return scenarioActions;
    }

    public void setScenarioActions(List<ActionWSDTO> scenarioActions) {
        this.scenarioActions = scenarioActions;
    }

    public List<AutomationWSDTO> getScenarioAutomations() {
        return scenarioAutomations;
    }

    public void setScenarioAutomations(List<AutomationWSDTO> scenarioAutomations) {
        this.scenarioAutomations = scenarioAutomations;
    }
}
