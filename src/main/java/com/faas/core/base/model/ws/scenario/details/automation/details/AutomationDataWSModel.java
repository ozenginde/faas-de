package com.faas.core.base.model.ws.scenario.details.automation.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.automation.details.dto.AutomationDataWSDTO;

import java.util.List;

public class AutomationDataWSModel {

    private GeneralWSModel general;
    private List<AutomationDataWSDTO>automationDatas;


    public AutomationDataWSModel() {
    }

    public AutomationDataWSModel(GeneralWSModel general, List<AutomationDataWSDTO> automationDatas) {
        this.general = general;
        this.automationDatas = automationDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationDataWSDTO> getAutomationDatas() {
        return automationDatas;
    }

    public void setAutomationDatas(List<AutomationDataWSDTO> automationDatas) {
        this.automationDatas = automationDatas;
    }
}
