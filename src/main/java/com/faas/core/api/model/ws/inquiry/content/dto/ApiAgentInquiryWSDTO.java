package com.faas.core.api.model.ws.inquiry.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;

import java.util.List;

public class ApiAgentInquiryWSDTO {

    private List<ApiSummaryWSDTO> clientInquirySummary;
    private List<ApiClientInquiryWSDTO>readyInquiries;
    private List<ApiClientInquiryWSDTO>activeInquiries;

    public ApiAgentInquiryWSDTO() {
    }

    public ApiAgentInquiryWSDTO(List<ApiSummaryWSDTO> clientInquirySummary, List<ApiClientInquiryWSDTO> readyInquiries, List<ApiClientInquiryWSDTO> activeInquiries) {
        this.clientInquirySummary = clientInquirySummary;
        this.readyInquiries = readyInquiries;
        this.activeInquiries = activeInquiries;
    }

    public List<ApiSummaryWSDTO> getClientInquirySummary() {
        return clientInquirySummary;
    }

    public void setClientInquirySummary(List<ApiSummaryWSDTO> clientInquirySummary) {
        this.clientInquirySummary = clientInquirySummary;
    }

    public List<ApiClientInquiryWSDTO> getReadyInquiries() {
        return readyInquiries;
    }

    public void setReadyInquiries(List<ApiClientInquiryWSDTO> readyInquiries) {
        this.readyInquiries = readyInquiries;
    }

    public List<ApiClientInquiryWSDTO> getActiveInquiries() {
        return activeInquiries;
    }

    public void setActiveInquiries(List<ApiClientInquiryWSDTO> activeInquiries) {
        this.activeInquiries = activeInquiries;
    }
}
