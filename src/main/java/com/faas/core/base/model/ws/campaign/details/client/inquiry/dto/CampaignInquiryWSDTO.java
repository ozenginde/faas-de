package com.faas.core.base.model.ws.campaign.details.client.inquiry.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.ClientInquiryWSDTO;

import java.util.List;

public class CampaignInquiryWSDTO {

    private List<ClientInquiryWSDTO>clientInquiries;
    private PaginationWSDTO pagination;

    public CampaignInquiryWSDTO() {
    }

    public CampaignInquiryWSDTO(List<ClientInquiryWSDTO> clientInquiries, PaginationWSDTO pagination) {
        this.clientInquiries = clientInquiries;
        this.pagination = pagination;
    }

    public List<ClientInquiryWSDTO> getClientInquiries() {
        return clientInquiries;
    }

    public void setClientInquiries(List<ClientInquiryWSDTO> clientInquiries) {
        this.clientInquiries = clientInquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
