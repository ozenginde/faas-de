package com.faas.core.base.model.ws.campaign.details.content.dto;


import com.faas.core.base.model.db.campaign.content.CampaignDBModel;

public class CampaignDetailsWSDTO {

    private CampaignDBModel campaign;
    private CampaignProcessWSDTO campaignProcess;

    public CampaignDetailsWSDTO() {
    }

    public CampaignDetailsWSDTO(CampaignDBModel campaign, CampaignProcessWSDTO campaignProcess) {
        this.campaign = campaign;
        this.campaignProcess = campaignProcess;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public CampaignProcessWSDTO getCampaignProcess() {
        return campaignProcess;
    }

    public void setCampaignProcess(CampaignProcessWSDTO campaignProcess) {
        this.campaignProcess = campaignProcess;
    }
}
