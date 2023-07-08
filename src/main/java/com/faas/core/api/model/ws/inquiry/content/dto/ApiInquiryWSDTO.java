package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;

public class ApiInquiryWSDTO {

    private ClientInquiryDBModel inquiry;

    public ApiInquiryWSDTO() {
    }

    public ApiInquiryWSDTO(ClientInquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public ClientInquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(ClientInquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
