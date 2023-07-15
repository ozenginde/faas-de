package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiDashCampaignWSModel {

    private GeneralWSModel general;
    private List<ApiDashCampaignWSDTO> dashCampaigns;

    public ApiDashCampaignWSModel() {
    }

    public ApiDashCampaignWSModel(GeneralWSModel general, List<ApiDashCampaignWSDTO> dashCampaigns) {
        this.general = general;
        this.dashCampaigns = dashCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiDashCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiDashCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
