package com.faas.core.base.model.ws.campaign.details.content;

import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignDetailsWSModel {

    private GeneralWSModel general;
    private CampaignDetailsWSDTO campaignDetails;

    public CampaignDetailsWSModel() {
    }

    public CampaignDetailsWSModel(GeneralWSModel general, CampaignDetailsWSDTO campaignDetails) {
        this.general = general;
        this.campaignDetails = campaignDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignDetailsWSDTO getCampaignDetails() {
        return campaignDetails;
    }

    public void setCampaignDetails(CampaignDetailsWSDTO campaignDetails) {
        this.campaignDetails = campaignDetails;
    }
}
