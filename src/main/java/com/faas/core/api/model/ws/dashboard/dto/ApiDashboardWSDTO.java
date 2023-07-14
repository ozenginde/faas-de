package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiSessionWSDTO readySessions;
    private ApiSessionWSDTO activeSessions;
    private ApiInquiryWSDTO dashInquiries;
    private List<ApiCampaignWSDTO> dashCampaigns;
    private List<ApiDashSummaryWSDTO> dashSummaries;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiSessionWSDTO readySessions, ApiSessionWSDTO activeSessions, ApiInquiryWSDTO dashInquiries, List<ApiCampaignWSDTO> dashCampaigns, List<ApiDashSummaryWSDTO> dashSummaries) {
        this.readySessions = readySessions;
        this.activeSessions = activeSessions;
        this.dashInquiries = dashInquiries;
        this.dashCampaigns = dashCampaigns;
        this.dashSummaries = dashSummaries;
    }

    public ApiSessionWSDTO getReadySessions() {
        return readySessions;
    }

    public void setReadySessions(ApiSessionWSDTO readySessions) {
        this.readySessions = readySessions;
    }

    public ApiSessionWSDTO getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(ApiSessionWSDTO activeSessions) {
        this.activeSessions = activeSessions;
    }

    public ApiInquiryWSDTO getDashInquiries() {
        return dashInquiries;
    }

    public void setDashInquiries(ApiInquiryWSDTO dashInquiries) {
        this.dashInquiries = dashInquiries;
    }

    public List<ApiCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }

    public List<ApiDashSummaryWSDTO> getDashSummaries() {
        return dashSummaries;
    }

    public void setDashSummaries(List<ApiDashSummaryWSDTO> dashSummaries) {
        this.dashSummaries = dashSummaries;
    }
}
