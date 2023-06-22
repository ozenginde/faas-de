package com.faas.core.base.model.ws.scenario.element.action.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionElementWSDTO;

import java.util.List;

public class ActionElementWSModel {

    private GeneralWSModel general;
    private List<ActionElementWSDTO> actionElements;

    public ActionElementWSModel() {
    }

    public ActionElementWSModel(GeneralWSModel general, List<ActionElementWSDTO> actionElements) {
        this.general = general;
        this.actionElements = actionElements;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionElementWSDTO> getActionElements() {
        return actionElements;
    }

    public void setActionElements(List<ActionElementWSDTO> actionElements) {
        this.actionElements = actionElements;
    }
}
