package com.faas.core.base.model.ws.inquiry.content.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class InquiryCampaignWSDTO {

    private CampaignWSDTO campaign;
    private List<InquiryWSDTO>inquiries;
    public PaginationWSDTO pagination;

    public InquiryCampaignWSDTO() {
    }

    public InquiryCampaignWSDTO(CampaignWSDTO campaign, List<InquiryWSDTO> inquiries, PaginationWSDTO pagination) {
        this.campaign = campaign;
        this.inquiries = inquiries;
        this.pagination = pagination;
    }

    public CampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignWSDTO campaign) {
        this.campaign = campaign;
    }

    public List<InquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<InquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
