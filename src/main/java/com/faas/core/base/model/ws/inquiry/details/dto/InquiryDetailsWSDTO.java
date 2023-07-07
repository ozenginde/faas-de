package com.faas.core.base.model.ws.inquiry.details.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;

public class InquiryDetailsWSDTO {

    private InquiryDBModel inquiry;

    public InquiryDetailsWSDTO() {
    }

    public InquiryDetailsWSDTO(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public InquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
