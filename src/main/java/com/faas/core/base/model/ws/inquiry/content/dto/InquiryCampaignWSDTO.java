package com.faas.core.base.model.ws.inquiry.content.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class InquiryCampaignWSDTO {

    private CampaignWSDTO campaign;
    private PaginationWSDTO pagination;
    private List<ClientInquiryWSDTO>clientInquiries;

    public InquiryCampaignWSDTO() {
    }

    public InquiryCampaignWSDTO(CampaignWSDTO campaign, PaginationWSDTO pagination, List<ClientInquiryWSDTO> clientInquiries) {
        this.campaign = campaign;
        this.pagination = pagination;
        this.clientInquiries = clientInquiries;
    }

    public CampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignWSDTO campaign) {
        this.campaign = campaign;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<ClientInquiryWSDTO> getClientInquiries() {
        return clientInquiries;
    }

    public void setClientInquiries(List<ClientInquiryWSDTO> clientInquiries) {
        this.clientInquiries = clientInquiries;
    }
}
