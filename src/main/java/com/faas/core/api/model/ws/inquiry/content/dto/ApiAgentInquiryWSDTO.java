package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;

import java.util.List;

public class ApiAgentInquiryWSDTO {

    private ApiInquiryWSDTO readyInquiry;
    private ApiInquiryWSDTO activeInquiry;
    private List<ApiSummaryWSDTO>inquirySummary;


    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(ApiInquiryWSDTO readyInquiry, ApiInquiryWSDTO activeInquiry, List<ApiSummaryWSDTO> inquirySummary) {
        this.readyInquiry = readyInquiry;
        this.activeInquiry = activeInquiry;
        this.inquirySummary = inquirySummary;
    }

    public ApiInquiryWSDTO getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(ApiInquiryWSDTO readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public ApiInquiryWSDTO getActiveInquiry() {
        return activeInquiry;
    }

    public void setActiveInquiry(ApiInquiryWSDTO activeInquiry) {
        this.activeInquiry = activeInquiry;
    }

    public List<ApiSummaryWSDTO> getInquirySummary() {
        return inquirySummary;
    }

    public void setInquirySummary(List<ApiSummaryWSDTO> inquirySummary) {
        this.inquirySummary = inquirySummary;
    }
}
