package com.faas.core.api.model.ws.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiCampaignWSModel {

    private GeneralWSModel general;
    private List<ApiCampaignWSDTO> campaigns;

    public ApiCampaignWSModel() {
    }

    public ApiCampaignWSModel(GeneralWSModel general, List<ApiCampaignWSDTO> campaigns) {
        this.general = general;
        this.campaigns = campaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<ApiCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
