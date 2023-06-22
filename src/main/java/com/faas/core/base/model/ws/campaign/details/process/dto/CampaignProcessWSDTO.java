package com.faas.core.base.model.ws.campaign.details.process.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;

import java.util.List;


public class CampaignProcessWSDTO {

    private ProcessDBModel campaignProcess;
    private List<ProcessScenarioWSDTO> processScenarios;

    public CampaignProcessWSDTO() {
    }

    public CampaignProcessWSDTO(ProcessDBModel campaignProcess, List<ProcessScenarioWSDTO> processScenarios) {
        this.campaignProcess = campaignProcess;
        this.processScenarios = processScenarios;
    }

    public ProcessDBModel getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(ProcessDBModel campaignProcess) {
        this.campaignProcess = campaignProcess;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
