package com.faas.core.api.model.ws.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiSmsTempWSModel {

    private GeneralWSModel general;
    private ApiSmsTempWSDTO smsTemp;

    public ApiSmsTempWSModel() {
    }

    public ApiSmsTempWSModel(GeneralWSModel general, ApiSmsTempWSDTO smsTemp) {
        this.general = general;
        this.smsTemp = smsTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiSmsTempWSDTO getSmsTemp() {
        return smsTemp;
    }

    public void setSmsTemp(ApiSmsTempWSDTO smsTemp) {
        this.smsTemp = smsTemp;
    }
}
