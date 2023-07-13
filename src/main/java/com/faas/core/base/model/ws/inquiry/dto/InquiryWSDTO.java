package com.faas.core.base.model.ws.inquiry.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;

public class InquiryWSDTO {

    private InquiryDBModel inquiry;

    public InquiryWSDTO() {
    }

    public InquiryWSDTO(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public InquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
