package com.faas.core.base.model.ws.inquiry.dto;

import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;

public class ClientInquiryWSDTO {

    private ClientInquiryDBModel clientInquiry;

    public ClientInquiryWSDTO() {
    }

    public ClientInquiryWSDTO(ClientInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public ClientInquiryDBModel getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(ClientInquiryDBModel clientInquiry) {
        this.clientInquiry = clientInquiry;
    }
}
