package com.faas.core.base.model.ws.campaign.details.client;

import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignClientWSModel {

    private GeneralWSModel general;
    private PaginationWSDTO pagination;
    private List<CampaignClientWSDTO>campaignClients;

    public CampaignClientWSModel() {
    }

    public CampaignClientWSModel(GeneralWSModel general, PaginationWSDTO pagination, List<CampaignClientWSDTO> campaignClients) {
        this.general = general;
        this.pagination = pagination;
        this.campaignClients = campaignClients;
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

    public List<CampaignClientWSDTO> getCampaignClients() {
        return campaignClients;
    }

    public void setCampaignClients(List<CampaignClientWSDTO> campaignClients) {
        this.campaignClients = campaignClients;
    }
}
