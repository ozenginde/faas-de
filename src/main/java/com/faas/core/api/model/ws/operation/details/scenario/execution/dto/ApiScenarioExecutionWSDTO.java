package com.faas.core.api.model.ws.operation.details.scenario.execution.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ApiScenarioExecutionWSDTO {

    private CampaignDBModel campaign;
    private ScenarioDBModel scenario;
    private ProcessScenarioDBModel processScenario;
    private ScenarioExecutionDBModel scenarioExecution;

    public ApiScenarioExecutionWSDTO() {
    }

    public ApiScenarioExecutionWSDTO(CampaignDBModel campaign, ScenarioDBModel scenario, ProcessScenarioDBModel processScenario, ScenarioExecutionDBModel scenarioExecution) {
        this.campaign = campaign;
        this.scenario = scenario;
        this.processScenario = processScenario;
        this.scenarioExecution = scenarioExecution;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ScenarioDBModel getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioDBModel scenario) {
        this.scenario = scenario;
    }

    public ProcessScenarioDBModel getProcessScenario() {
        return processScenario;
    }

    public void setProcessScenario(ProcessScenarioDBModel processScenario) {
        this.processScenario = processScenario;
    }

    public ScenarioExecutionDBModel getScenarioExecution() {
        return scenarioExecution;
    }

    public void setScenarioExecution(ScenarioExecutionDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }
}
