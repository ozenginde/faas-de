package com.faas.core.base.model.ws.session.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;

public class SessionWSDTO {

    private SessionDBModel session;

    public SessionWSDTO() {
    }

    public SessionWSDTO(SessionDBModel session) {
        this.session = session;
    }

    public SessionDBModel getSession() {
        return session;
    }

    public void setSession(SessionDBModel session) {
        this.session = session;
    }
}
