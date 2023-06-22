package com.faas.core.api.model.ws.operation.channel.call.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;



public class ApiWappCallWSModel {

    private GeneralWSModel general;
    private ApiWappCallWSDTO wappCall;

    public ApiWappCallWSModel() {
    }

    public ApiWappCallWSModel(GeneralWSModel general, ApiWappCallWSDTO wappCall) {
        this.general = general;
        this.wappCall = wappCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiWappCallWSDTO getWappCall() {
        return wappCall;
    }

    public void setWappCall(ApiWappCallWSDTO wappCall) {
        this.wappCall = wappCall;
    }
}
