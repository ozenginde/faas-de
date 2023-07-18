package com.faas.core.api.model.ws.inquiry.content.dto;

public class ApiAgentInquiryWSDTO {

    private ApiInquiryWrapper readyInquiry;
    private ApiInquiryWrapper activeInquiry;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(ApiInquiryWrapper readyInquiry, ApiInquiryWrapper activeInquiry) {
        this.readyInquiry = readyInquiry;
        this.activeInquiry = activeInquiry;
    }

    public ApiInquiryWrapper getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(ApiInquiryWrapper readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public ApiInquiryWrapper getActiveInquiry() {
        return activeInquiry;
    }

    public void setActiveInquiry(ApiInquiryWrapper activeInquiry) {
        this.activeInquiry = activeInquiry;
    }
}
