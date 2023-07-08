package com.faas.core.base.model.ws.campaign.details.client.flow.dto;

import com.faas.core.base.model.ws.flow.content.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignFlowWSDTO {

    private List<ClientFlowWSDTO> clientFlows;
    private PaginationWSDTO pagination;

    public CampaignFlowWSDTO() {
    }

    public CampaignFlowWSDTO(List<ClientFlowWSDTO> clientFlows, PaginationWSDTO pagination) {
        this.clientFlows = clientFlows;
        this.pagination = pagination;
    }

    public List<ClientFlowWSDTO> getClientFlows() {
        return clientFlows;
    }

    public void setClientFlows(List<ClientFlowWSDTO> clientFlows) {
        this.clientFlows = clientFlows;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
