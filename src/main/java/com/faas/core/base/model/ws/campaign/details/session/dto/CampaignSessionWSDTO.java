package com.faas.core.base.model.ws.campaign.details.session.dto;

import com.faas.core.base.model.db.session.SessionDBModel;

public class CampaignSessionWSDTO {

    private SessionDBModel campaignSession;

    public CampaignSessionWSDTO() {
    }

    public CampaignSessionWSDTO(SessionDBModel campaignSession) {
        this.campaignSession = campaignSession;
    }

    public SessionDBModel getCampaignSession() {
        return campaignSession;
    }

    public void setCampaignSession(SessionDBModel campaignSession) {
        this.campaignSession = campaignSession;
    }
}
