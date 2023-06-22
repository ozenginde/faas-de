package com.faas.core.base.model.ws.campaign.details.session;

import com.faas.core.base.model.ws.campaign.details.session.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignSessionWSModel {

    private GeneralWSModel general;
    private PaginationWSDTO pagination;
    private List<CampaignSessionWSDTO> campaignSessions;

    public CampaignSessionWSModel() {
    }

    public CampaignSessionWSModel(GeneralWSModel general, PaginationWSDTO pagination, List<CampaignSessionWSDTO> campaignSessions) {
        this.general = general;
        this.pagination = pagination;
        this.campaignSessions = campaignSessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<CampaignSessionWSDTO> getCampaignSessions() {
        return campaignSessions;
    }

    public void setCampaignSessions(List<CampaignSessionWSDTO> campaignSessions) {
        this.campaignSessions = campaignSessions;
    }
}
