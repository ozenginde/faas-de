package com.faas.core.api.model.ws.operation.channel.message.email;

import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiEmailMessageTempWSModel {

    private GeneralWSModel general;
    private List<ApiEmailMessageTempWSDTO>emailTemps;

    public ApiEmailMessageTempWSModel() {
    }

    public ApiEmailMessageTempWSModel(GeneralWSModel general, List<ApiEmailMessageTempWSDTO> emailTemps) {
        this.general = general;
        this.emailTemps = emailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiEmailMessageTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<ApiEmailMessageTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }
}
