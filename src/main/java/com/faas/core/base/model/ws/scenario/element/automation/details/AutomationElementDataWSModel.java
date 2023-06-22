package com.faas.core.base.model.ws.scenario.element.automation.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.automation.details.dto.AutomationElementDataWSDTO;

import java.util.List;

public class AutomationElementDataWSModel {

    private GeneralWSModel general;
    private List<AutomationElementDataWSDTO>elementDatas;


    public AutomationElementDataWSModel() {
    }

    public AutomationElementDataWSModel(GeneralWSModel general, List<AutomationElementDataWSDTO> elementDatas) {
        this.general = general;
        this.elementDatas = elementDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationElementDataWSDTO> getElementDatas() {
        return elementDatas;
    }

    public void setElementDatas(List<AutomationElementDataWSDTO> elementDatas) {
        this.elementDatas = elementDatas;
    }
}
