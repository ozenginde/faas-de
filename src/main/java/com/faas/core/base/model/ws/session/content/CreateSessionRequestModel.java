package com.faas.core.base.model.ws.session.content;

import com.faas.core.base.model.ws.session.content.dto.CreateSessionRequestWSDTO;

import java.util.List;

public class CreateSessionRequestModel {

    private List<CreateSessionRequestWSDTO>sessionRequests;

    public CreateSessionRequestModel() {
    }

    public CreateSessionRequestModel(List<CreateSessionRequestWSDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }

    public List<CreateSessionRequestWSDTO> getSessionRequests() {
        return sessionRequests;
    }

    public void setSessionRequests(List<CreateSessionRequestWSDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }
}
