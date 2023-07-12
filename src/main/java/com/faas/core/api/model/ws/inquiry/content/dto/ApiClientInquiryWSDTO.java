package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;

public class ApiClientInquiryWSDTO {

    private ClientInquiryDBModel clientInquiry;

    public ApiClientInquiryWSDTO() {
    }

    public ApiClientInquiryWSDTO(ClientInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public ClientInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(ClientInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
