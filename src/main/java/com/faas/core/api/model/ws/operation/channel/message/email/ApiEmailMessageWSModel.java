package com.faas.core.api.model.ws.operation.channel.message.email;

import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiEmailMessageWSModel {

    private GeneralWSModel general;
    private List<ApiEmailMessageWSDTO> emailMessages;

    public ApiEmailMessageWSModel() {
    }

    public ApiEmailMessageWSModel(GeneralWSModel general, List<ApiEmailMessageWSDTO> emailMessages) {
        this.general = general;
        this.emailMessages = emailMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiEmailMessageWSDTO> getEmailMessages() {
        return emailMessages;
    }

    public void setEmailMessages(List<ApiEmailMessageWSDTO> emailMessages) {
        this.emailMessages = emailMessages;
    }
}
