package com.faas.core.base.model.ws.inquiry.details.dto;

import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;

public class ClientInquiryDetailsWSDTO {

    private ClientInquiryDBModel inquiry;

    public ClientInquiryDetailsWSDTO() {
    }

    public ClientInquiryDetailsWSDTO(ClientInquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }

    public ClientInquiryDBModel getInquiry() {
        return inquiry;
    }

    public void setInquiry(ClientInquiryDBModel inquiry) {
        this.inquiry = inquiry;
    }
}
