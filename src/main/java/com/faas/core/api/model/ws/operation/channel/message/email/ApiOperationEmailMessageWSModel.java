package com.faas.core.api.model.ws.operation.channel.message.email;

import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationEmailMessageWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailMessageWSDTO operationEmailMessage;

    public ApiOperationEmailMessageWSModel() {
    }

    public ApiOperationEmailMessageWSModel(GeneralWSModel general, ApiOperationEmailMessageWSDTO operationEmailMessage) {
        this.general = general;
        this.operationEmailMessage = operationEmailMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationEmailMessageWSDTO getOperationEmailMessage() {
        return operationEmailMessage;
    }

    public void setOperationEmailMessage(ApiOperationEmailMessageWSDTO operationEmailMessage) {
        this.operationEmailMessage = operationEmailMessage;
    }
}
