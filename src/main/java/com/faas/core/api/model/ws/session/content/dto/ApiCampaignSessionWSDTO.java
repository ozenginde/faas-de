package com.faas.core.api.model.ws.session.content.dto;

public class ApiCampaignSessionWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;

    public ApiCampaignSessionWSDTO() {
    }

    public ApiCampaignSessionWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession) {
        this.readySession = readySession;
        this.activeSession = activeSession;
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
}
