package com.faas.core.api.model.ws.operation.scenario.execute.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.details.ScenarioExecuteDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;

public class ApiScenarioExecuteWSDTO {

    private CampaignDBModel campaign;
    private ScenarioDBModel scenario;
    private ProcessScenarioDBModel processScenario;
    private ScenarioExecuteDBModel scenarioExecution;

    public ApiScenarioExecuteWSDTO() {
    }

    public ApiScenarioExecuteWSDTO(CampaignDBModel campaign, ScenarioDBModel scenario, ProcessScenarioDBModel processScenario, ScenarioExecuteDBModel scenarioExecution) {
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

    public ScenarioExecuteDBModel getScenarioExecution() {
        return scenarioExecution;
    }

    public void setScenarioExecution(ScenarioExecuteDBModel scenarioExecution) {
        this.scenarioExecution = scenarioExecution;
    }
}
