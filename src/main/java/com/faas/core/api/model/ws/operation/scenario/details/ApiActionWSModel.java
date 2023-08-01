package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiActionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiActionWSModel {

    private GeneralWSModel general;
    private List<ApiActionWSDTO>actions;


    public ApiActionWSModel() {
    }

    public ApiActionWSModel(GeneralWSModel general, List<ApiActionWSDTO> actions) {
        this.general = general;
        this.actions = actions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiActionWSDTO> getActions() {
        return actions;
    }

    public void setActions(List<ApiActionWSDTO> actions) {
        this.actions = actions;
    }
}
