package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;

import java.util.List;

public class ApiAgentInquiryWSDTO {

    private List<ApiSummaryWSDTO> inquirySummary;
    private List<ApiInquiryWSDTO>readyInquiries;
    private List<ApiInquiryWSDTO>activeInquiries;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(List<ApiSummaryWSDTO> inquirySummary, List<ApiInquiryWSDTO> readyInquiries, List<ApiInquiryWSDTO> activeInquiries) {
        this.inquirySummary = inquirySummary;
        this.readyInquiries = readyInquiries;
        this.activeInquiries = activeInquiries;
    }

    public List<ApiSummaryWSDTO> getInquirySummary() {
        return inquirySummary;
    }

    public void setInquirySummary(List<ApiSummaryWSDTO> inquirySummary) {
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
}
