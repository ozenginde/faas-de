package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;
    private ApiInquiryWSDTO readyInquiry;
    private ApiInquiryWSDTO activeInquiry;
    private List<ApiCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession, ApiInquiryWSDTO readyInquiry, ApiInquiryWSDTO activeInquiry, List<ApiCampaignWSDTO> dashCampaigns) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.readyInquiry = readyInquiry;
        this.activeInquiry = activeInquiry;
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

    public List<ApiCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
