package com.faas.core.base.model.ws.inquiry.manager.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;

public class InquiryManagerWSDTO {

    private InquiryDBModel inquiry;

    public InquiryManagerWSDTO() {
    }

    public InquiryManagerWSDTO(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public InquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
