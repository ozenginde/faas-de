package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiAgentSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiAgentSessionWSDTO agentSession;
    private List<ApiCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiAgentSessionWSDTO agentSession, List<ApiCampaignWSDTO> dashCampaigns) {
        this.agentSession = agentSession;
        this.dashCampaigns = dashCampaigns;
    }

    public ApiAgentSessionWSDTO getAgentSession() {
        return agentSession;
    }

    public void setAgentSession(ApiAgentSessionWSDTO agentSession) {
        this.agentSession = agentSession;
    }

    public List<ApiCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
