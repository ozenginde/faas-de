package com.faas.core.api.model.ws.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiSmsWSModel {

    private GeneralWSModel general;
    private List<ApiSmsWSDTO> smss;

    public ApiSmsWSModel() {
    }

    public ApiSmsWSModel(GeneralWSModel general, List<ApiSmsWSDTO> smss) {
        this.general = general;
        this.smss = smss;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSmsWSDTO> getSmss() {
        return smss;
    }

    public void setSmss(List<ApiSmsWSDTO> smss) {
        this.smss = smss;
    }
}
