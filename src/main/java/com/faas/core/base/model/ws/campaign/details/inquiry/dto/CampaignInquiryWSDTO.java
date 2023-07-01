package com.faas.core.base.model.ws.campaign.details.inquiry.dto;

import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignInquiryWSDTO {

    private List<ClientWSDTO> clients;
    private PaginationWSDTO pagination;

    public CampaignInquiryWSDTO() {
    }

    public CampaignInquiryWSDTO(List<ClientWSDTO> clients, PaginationWSDTO pagination) {
        this.clients = clients;
        this.pagination = pagination;
    }

    public List<ClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientWSDTO> clients) {
        this.clients = clients;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
