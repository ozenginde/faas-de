package com.faas.core.api.model.ws.session.details;

import com.faas.core.api.model.ws.session.details.dto.ApiSessionClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiSessionClientWSModel {

    private GeneralWSModel general;
    private List<ApiSessionClientWSDTO>clients;


    public ApiSessionClientWSModel() {
    }

    public ApiSessionClientWSModel(GeneralWSModel general, List<ApiSessionClientWSDTO> clients) {
        this.general = general;
        this.clients = clients;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSessionClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ApiSessionClientWSDTO> clients) {
        this.clients = clients;
    }
}
