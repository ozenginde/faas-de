package com.faas.core.base.model.ws.flow.content.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class FlowCampaignWSDTO {

    private CampaignWSDTO campaign;
    private List<FlowWSDTO>flows;
    public PaginationWSDTO pagination;

    public FlowCampaignWSDTO() {
    }

    public FlowCampaignWSDTO(CampaignWSDTO campaign, List<FlowWSDTO> flows, PaginationWSDTO pagination) {
        this.campaign = campaign;
        this.flows = flows;
        this.pagination = pagination;
    }

    public CampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignWSDTO campaign) {
        this.campaign = campaign;
    }

    public List<FlowWSDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<FlowWSDTO> flows) {
        this.flows = flows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
