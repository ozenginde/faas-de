package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;
    private ApiInquiryWSDTO dashInquiry;
    private List<ApiDashCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession, ApiInquiryWSDTO dashInquiry, List<ApiDashCampaignWSDTO> dashCampaigns) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.dashInquiry = dashInquiry;
        this.dashCampaigns = dashCampaigns;
    }

    public ApiSessionWSDTO getReadySession() {
        return readySession;
    }

    public void setReadySession(ApiSessionWSDTO readySession) {
        this.readySession = readySession;
    }

    public ApiSessionWSDTO getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(ApiSessionWSDTO activeSession) {
        this.activeSession = activeSession;
    }

    public ApiInquiryWSDTO getDashInquiry() {
        return dashInquiry;
    }

    public void setDashInquiry(ApiInquiryWSDTO dashInquiry) {
        this.dashInquiry = dashInquiry;
    }

    public List<ApiDashCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiDashCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
