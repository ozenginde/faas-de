package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;

import java.util.List;

public class ApiAgentInquiryWSDTO {

    private List<ApiInquiryWSDTO>readyInquiries;
    private List<ApiInquiryWSDTO>activeInquiries;
    private List<ApiSummaryWSDTO> inquirySummary;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(List<ApiInquiryWSDTO> readyInquiries, List<ApiInquiryWSDTO> activeInquiries, List<ApiSummaryWSDTO> inquirySummary) {
        this.readyInquiries = readyInquiries;
        this.activeInquiries = activeInquiries;
        this.inquirySummary = inquirySummary;
    }

    public List<ApiInquiryWSDTO> getReadyInquiries() {
        return readyInquiries;
    }

    public void setReadyInquiries(List<ApiInquiryWSDTO> readyInquiries) {
        this.readyInquiries = readyInquiries;
    }

    public List<ApiInquiryWSDTO> getActiveInquiries() {
        return activeInquiries;
    }

    public void setActiveInquiries(List<ApiInquiryWSDTO> activeInquiries) {
        this.activeInquiries = activeInquiries;
    }

    public List<ApiSummaryWSDTO> getInquirySummary() {
        return inquirySummary;
    }

    public void setInquirySummary(List<ApiSummaryWSDTO> inquirySummary) {
        this.inquirySummary = inquirySummary;
    }
}
