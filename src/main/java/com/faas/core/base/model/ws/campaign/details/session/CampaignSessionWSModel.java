package com.faas.core.base.model.ws.campaign.details.session;

import com.faas.core.base.model.ws.campaign.details.session.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignSessionWSModel {

    private GeneralWSModel general;
    private CampaignSessionWSDTO campaignSession;

    public CampaignSessionWSModel() {
    }

    public CampaignSessionWSModel(GeneralWSModel general, CampaignSessionWSDTO campaignSession) {
        this.general = general;
        this.campaignSession = campaignSession;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignSessionWSDTO getCampaignSession() {
        return campaignSession;
    }

    public void setCampaignSession(CampaignSessionWSDTO campaignSession) {
        this.campaignSession = campaignSession;
    }
}
