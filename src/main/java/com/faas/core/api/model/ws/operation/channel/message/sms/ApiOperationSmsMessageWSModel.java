package com.faas.core.api.model.ws.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationSmsMessageWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsMessageWSDTO operationSmsMessage;

    public ApiOperationSmsMessageWSModel() {
    }

    public ApiOperationSmsMessageWSModel(GeneralWSModel general, ApiOperationSmsMessageWSDTO operationSmsMessage) {
        this.general = general;
        this.operationSmsMessage = operationSmsMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsMessageWSDTO getOperationSmsMessage() {
        return operationSmsMessage;
    }

    public void setOperationSmsMessage(ApiOperationSmsMessageWSDTO operationSmsMessage) {
        this.operationSmsMessage = operationSmsMessage;
    }
}
