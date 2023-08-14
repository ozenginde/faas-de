package com.faas.core.api.model.ws.agent.details.dto;

public class ApiAgentInfoWSDTO {

    private long readySession;
    private long activeSession;
    private long readyInquiries;
    private long activeInquiries;

    public ApiAgentInfoWSDTO() {
    }

    public ApiAgentInfoWSDTO(long readySession, long activeSession, long readyInquiries, long activeInquiries) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.readyInquiries = readyInquiries;
        this.activeInquiries = activeInquiries;
    }

    public long getReadySession() {
        return readySession;
    }

    public void setReadySession(long readySession) {
        this.readySession = readySession;
    }

    public long getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(long activeSession) {
        this.activeSession = activeSession;
    }

    public long getReadyInquiries() {
        return readyInquiries;
    }

    public void setReadyInquiries(long readyInquiries) {
        this.readyInquiries = readyInquiries;
    }

    public long getActiveInquiries() {
        return activeInquiries;
    }

    public void setActiveInquiries(long activeInquiries) {
        this.activeInquiries = activeInquiries;
    }
}
