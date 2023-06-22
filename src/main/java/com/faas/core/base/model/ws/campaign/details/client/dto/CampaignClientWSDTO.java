package com.faas.core.base.model.ws.campaign.details.client.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;

public class CampaignClientWSDTO {

    private ClientDBModel campaignClient;

    public CampaignClientWSDTO() {
    }

    public CampaignClientWSDTO(ClientDBModel campaignClient) {
        this.campaignClient = campaignClient;
    }

    public ClientDBModel getCampaignClient() {
        return campaignClient;
    }

    public void setCampaignClient(ClientDBModel campaignClient) {
        this.campaignClient = campaignClient;
    }
}
