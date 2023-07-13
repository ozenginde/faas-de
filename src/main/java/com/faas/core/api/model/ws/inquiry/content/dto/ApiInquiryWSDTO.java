package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.InquiryDBModel;

public class ApiInquiryWSDTO {

    private InquiryDBModel clientInquiry;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(InquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public InquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(InquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
