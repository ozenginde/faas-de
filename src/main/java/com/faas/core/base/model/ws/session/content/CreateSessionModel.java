package com.faas.core.base.model.ws.session.content;

import com.faas.core.base.model.ws.session.content.dto.CreateSessionWSDTO;

import java.util.List;

public class CreateSessionModel {

    private List<CreateSessionWSDTO>createSessions;

    public CreateSessionModel() {
    }

    public CreateSessionModel(List<CreateSessionWSDTO> createSessions) {
        this.createSessions = createSessions;
    }

    public List<CreateSessionWSDTO> getCreateSessions() {
        return createSessions;
    }

    public void setCreateSessions(List<CreateSessionWSDTO> createSessions) {
        this.createSessions = createSessions;
    }
}
