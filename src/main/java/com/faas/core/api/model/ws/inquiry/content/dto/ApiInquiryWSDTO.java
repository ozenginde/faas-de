package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.content.InquiryDBModel;

public class ApiInquiryWSDTO {

    private InquiryDBModel inquiry;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public InquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
