package com.faas.core.base.model.ws.scenario.element.action.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.element.action.content.dto.ActionWSDTO;

import java.util.List;

public class ActionWSModel {

    private GeneralWSModel general;
    private List<ActionWSDTO> actions;

    public ActionWSModel() {
    }

    public ActionWSModel(GeneralWSModel general, List<ActionWSDTO> actions) {
        this.general = general;
        this.actions = actions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionWSDTO> getActions() {
        return actions;
    }

    public void setActions(List<ActionWSDTO> actions) {
        this.actions = actions;
    }
}
