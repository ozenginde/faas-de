package com.faas.core.api.model.ws.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationSmsWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsWSDTO operationSms;

    public ApiOperationSmsWSModel() {
    }

    public ApiOperationSmsWSModel(GeneralWSModel general, ApiOperationSmsWSDTO operationSms) {
        this.general = general;
        this.operationSms = operationSms;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsWSDTO getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(ApiOperationSmsWSDTO operationSms) {
        this.operationSms = operationSms;
    }
}
