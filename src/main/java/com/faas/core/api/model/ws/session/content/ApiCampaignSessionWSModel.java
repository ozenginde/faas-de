package com.faas.core.api.model.ws.session.content;

import com.faas.core.api.model.ws.session.content.dto.ApiCampaignSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiCampaignSessionWSModel {

    private GeneralWSModel general;
    private ApiCampaignSessionWSDTO campaignSession;

    public ApiCampaignSessionWSModel() {
    }

    public ApiCampaignSessionWSModel(GeneralWSModel general, ApiCampaignSessionWSDTO campaignSession) {
        this.general = general;
        this.campaignSession = campaignSession;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiCampaignSessionWSDTO getCampaignSession() {
        return campaignSession;
    }

    public void setCampaignSession(ApiCampaignSessionWSDTO campaignSession) {
        this.campaignSession = campaignSession;
    }
}
