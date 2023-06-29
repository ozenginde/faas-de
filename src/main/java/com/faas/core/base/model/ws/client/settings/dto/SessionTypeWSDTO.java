package com.faas.core.base.model.ws.client.settings.dto;

import com.faas.core.base.model.db.client.settings.SessionTypeDBModel;

public class SessionTypeWSDTO {

    private SessionTypeDBModel sessionType;

    public SessionTypeWSDTO() {
    }

    public SessionTypeWSDTO(SessionTypeDBModel sessionType) {
        this.sessionType = sessionType;
    }

    public SessionTypeDBModel getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionTypeDBModel sessionType) {
        this.sessionType = sessionType;
    }
}

