package com.faas.core.api.model.ws.session.content.dto;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;

import java.util.List;

public class ApiAgentSessionWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;
    private List<ApiSummaryWSDTO> sessionSummary;

    public ApiAgentSessionWSDTO() {
    }

    public ApiAgentSessionWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession, List<ApiSummaryWSDTO> sessionSummary) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.sessionSummary = sessionSummary;
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

    public List<ApiSummaryWSDTO> getSessionSummary() {
        return sessionSummary;
    }

    public void setSessionSummary(List<ApiSummaryWSDTO> sessionSummary) {
        this.sessionSummary = sessionSummary;
    }
}
