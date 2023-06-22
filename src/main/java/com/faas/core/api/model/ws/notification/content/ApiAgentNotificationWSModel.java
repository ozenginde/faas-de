package com.faas.core.api.model.ws.notification.content;

import com.faas.core.api.model.ws.notification.content.dto.ApiAgentNotificationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentNotificationWSModel {

    private GeneralWSModel general;
    private ApiAgentNotificationWSDTO agentNotification;

    public ApiAgentNotificationWSModel() {
    }

    public ApiAgentNotificationWSModel(GeneralWSModel general, ApiAgentNotificationWSDTO agentNotification) {
        this.general = general;
        this.agentNotification = agentNotification;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentNotificationWSDTO getAgentNotification() {
        return agentNotification;
    }

    public void setAgentNotification(ApiAgentNotificationWSDTO agentNotification) {
        this.agentNotification = agentNotification;
    }
}
