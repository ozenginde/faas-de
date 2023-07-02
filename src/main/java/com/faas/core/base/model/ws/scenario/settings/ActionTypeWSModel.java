package com.faas.core.base.model.ws.scenario.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.settings.dto.ActionTypeWSDTO;

import java.util.List;

public class ActionTypeWSModel {

    private GeneralWSModel general;
    private List<ActionTypeWSDTO> actionTypes;


    public ActionTypeWSModel() {
    }

    public ActionTypeWSModel(GeneralWSModel general, List<ActionTypeWSDTO> actionTypes) {
        this.general = general;
        this.actionTypes = actionTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionTypeWSDTO> getActionTypes() {
        return actionTypes;
    }

    public void setActionTypes(List<ActionTypeWSDTO> actionTypes) {
        this.actionTypes = actionTypes;
    }
}
