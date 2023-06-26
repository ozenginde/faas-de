package com.faas.core.base.model.ws.campaign.details.client.dto;

import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignClientWSDTO {

    private PaginationWSDTO pagination;
    private List<ClientWSDTO> clients;

    public CampaignClientWSDTO() {
    }

    public CampaignClientWSDTO(PaginationWSDTO pagination, List<ClientWSDTO> clients) {
        this.pagination = pagination;
        this.clients = clients;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<ClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientWSDTO> clients) {
        this.clients = clients;
    }
}
