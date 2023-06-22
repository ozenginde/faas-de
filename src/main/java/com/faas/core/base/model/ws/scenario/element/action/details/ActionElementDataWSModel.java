package com.faas.core.base.model.ws.scenario.element.action.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.action.details.dto.ActionElementDataWSDTO;

import java.util.List;

public class ActionElementDataWSModel {

    private GeneralWSModel general;
    private List<ActionElementDataWSDTO> elementDatas;


    public ActionElementDataWSModel() {
    }

    public ActionElementDataWSModel(GeneralWSModel general, List<ActionElementDataWSDTO> elementDatas) {
        this.general = general;
        this.elementDatas = elementDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionElementDataWSDTO> getElementDatas() {
        return elementDatas;
    }

    public void setElementDatas(List<ActionElementDataWSDTO> elementDatas) {
        this.elementDatas = elementDatas;
    }
}
