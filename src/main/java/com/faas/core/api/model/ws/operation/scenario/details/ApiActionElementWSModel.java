package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiActionElementWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiActionElementWSModel {

    private GeneralWSModel general;
    private List<ApiActionElementWSDTO>actionElements;


    public ApiActionElementWSModel() {
    }

    public ApiActionElementWSModel(GeneralWSModel general, List<ApiActionElementWSDTO> actionElements) {
        this.general = general;
        this.actionElements = actionElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiActionElementWSDTO> getActionElements() {
        return actionElements;
    }

    public void setActionElements(List<ApiActionElementWSDTO> actionElements) {
        this.actionElements = actionElements;
    }
}
