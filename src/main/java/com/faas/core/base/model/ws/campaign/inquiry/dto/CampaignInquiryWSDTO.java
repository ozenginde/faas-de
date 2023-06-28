package com.faas.core.base.model.ws.campaign.inquiry.dto;

import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignInquiryWSDTO {

    private GeneralWSModel general;
    private CampaignClientWSDTO campaignClient;

    public CampaignInquiryWSDTO() {
    }

    public CampaignInquiryWSDTO(GeneralWSModel general, CampaignClientWSDTO campaignClient) {
        this.general = general;
        this.campaignClient = campaignClient;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignClientWSDTO getCampaignClient() {
        return campaignClient;
    }

    public void setCampaignClient(CampaignClientWSDTO campaignClient) {
        this.campaignClient = campaignClient;
    }
}
