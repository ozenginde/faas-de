package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiAgentSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiAgentSessionWSDTO dashSession;
    private List<ApiSummaryWSDTO> dashSummaries;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiAgentSessionWSDTO dashSession, List<ApiSummaryWSDTO> dashSummaries) {
        this.dashSession = dashSession;
        this.dashSummaries = dashSummaries;
    }

    public ApiAgentSessionWSDTO getDashSession() {
        return dashSession;
    }

    public void setDashSession(ApiAgentSessionWSDTO dashSession) {
        this.dashSession = dashSession;
    }

    public List<ApiSummaryWSDTO> getDashSummaries() {
        return dashSummaries;
    }

    public void setDashSummaries(List<ApiSummaryWSDTO> dashSummaries) {
        this.dashSummaries = dashSummaries;
    }
}
