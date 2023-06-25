package com.faas.core.base.model.ws.scenario.element.automation.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.content.dto.AutomationWSDTO;

import java.util.List;

public class AutomationWSModel {

    private GeneralWSModel general;
    private List<AutomationWSDTO>automations;

    public AutomationWSModel() {
    }

    public AutomationWSModel(GeneralWSModel general, List<AutomationWSDTO> automations) {
        this.general = general;
        this.automations = automations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationWSDTO> getAutomations() {
        return automations;
    }

    public void setAutomations(List<AutomationWSDTO> automations) {
        this.automations = automations;
    }
}
