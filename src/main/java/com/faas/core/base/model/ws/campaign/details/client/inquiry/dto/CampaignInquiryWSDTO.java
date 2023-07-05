package com.faas.core.base.model.ws.campaign.details.client.inquiry.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;

import java.util.List;

public class CampaignInquiryWSDTO {

    private List<InquiryWSDTO>inquiries;
    private PaginationWSDTO pagination;

    public CampaignInquiryWSDTO() {
    }

    public CampaignInquiryWSDTO(List<InquiryWSDTO> inquiries, PaginationWSDTO pagination) {
        this.inquiries = inquiries;
        this.pagination = pagination;
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
