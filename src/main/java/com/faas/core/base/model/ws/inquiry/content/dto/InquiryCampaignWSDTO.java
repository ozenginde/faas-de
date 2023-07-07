package com.faas.core.base.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;

public class InquiryCampaignWSDTO {

    private InquiryDBModel inquiry;

    public InquiryCampaignWSDTO() {
    }

    public InquiryCampaignWSDTO(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public InquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
