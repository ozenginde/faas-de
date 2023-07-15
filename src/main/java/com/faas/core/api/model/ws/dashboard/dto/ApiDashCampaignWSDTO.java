package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;

import java.util.List;

public class ApiDashCampaignWSDTO {

    private CampaignDBModel campaign;
    private ProcessDBModel campaignProcess;
    private List<ApiSummaryWSDTO> campaignSummary;

    public ApiDashCampaignWSDTO() {
    }

    public ApiDashCampaignWSDTO(CampaignDBModel campaign, ProcessDBModel campaignProcess, List<ApiSummaryWSDTO> campaignSummary) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
        this.campaignSummary = campaignSummary;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ProcessDBModel getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(ProcessDBModel campaignProcess) {
        this.campaignProcess = campaignProcess;
    }

    public List<ApiSummaryWSDTO> getCampaignSummary() {
        return campaignSummary;
    }

    public void setCampaignSummary(List<ApiSummaryWSDTO> campaignSummary) {
        this.campaignSummary = campaignSummary;
    }
}
