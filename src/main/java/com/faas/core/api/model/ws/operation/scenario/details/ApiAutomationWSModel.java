package com.faas.core.api.model.ws.operation.scenario.details;

import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiAutomationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiAutomationWSModel {

    private GeneralWSModel general;
    private List<ApiAutomationWSDTO>automations;

    public ApiAutomationWSModel() {
    }

    public ApiAutomationWSModel(GeneralWSModel general, List<ApiAutomationWSDTO> automations) {
        this.general = general;
        this.automations = automations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiAutomationWSDTO> getAutomations() {
        return automations;
    }

    public void setAutomations(List<ApiAutomationWSDTO> automations) {
        this.automations = automations;
    }
}
