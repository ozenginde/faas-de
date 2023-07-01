package com.faas.core.base.model.ws.campaign.details.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;


public class CampaignProcessWSDTO {

    private ProcessScenarioDBModel process;
    private ProcessDBModel processDetails;

    public CampaignProcessWSDTO() {
    }

    public CampaignProcessWSDTO(ProcessScenarioDBModel process, ProcessDBModel processDetails) {
        this.process = process;
        this.processDetails = processDetails;
    }

    public ProcessScenarioDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessScenarioDBModel process) {
        this.process = process;
    }

    public ProcessDBModel getProcessDetails() {
        return processDetails;
    }

    public void setProcessDetails(ProcessDBModel processDetails) {
        this.processDetails = processDetails;
    }
}
