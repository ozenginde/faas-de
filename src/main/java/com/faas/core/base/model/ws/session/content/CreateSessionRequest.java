package com.faas.core.base.model.ws.session.content;

import com.faas.core.base.model.ws.session.content.dto.CreateSessionRequestDTO;

import java.util.List;

public class CreateSessionRequest {

    private List<CreateSessionRequestDTO>createSessions;

    public CreateSessionRequest() {
    }

    public CreateSessionRequest(List<CreateSessionRequestDTO> createSessions) {
        this.createSessions = createSessions;
    }

    public List<CreateSessionRequestDTO> getCreateSessions() {
        return createSessions;
    }

    public void setCreateSessions(List<CreateSessionRequestDTO> createSessions) {
        this.createSessions = createSessions;
    }
}
