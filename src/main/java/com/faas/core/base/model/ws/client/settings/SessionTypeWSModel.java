package com.faas.core.base.model.ws.client.settings;

import com.faas.core.base.model.ws.client.settings.dto.SessionTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class SessionTypeWSModel {

    private GeneralWSModel general;
    private List<SessionTypeWSDTO>sessionTypes;

    public SessionTypeWSModel() {
    }

    public SessionTypeWSModel(GeneralWSModel general, List<SessionTypeWSDTO> sessionTypes) {
        this.general = general;
        this.sessionTypes = sessionTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SessionTypeWSDTO> getSessionTypes() {
        return sessionTypes;
    }

    public void setSessionTypes(List<SessionTypeWSDTO> sessionTypes) {
        this.sessionTypes = sessionTypes;
    }
}
