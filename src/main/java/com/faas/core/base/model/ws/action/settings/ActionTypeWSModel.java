package com.faas.core.base.model.ws.action.settings;

import com.faas.core.base.model.ws.action.settings.dto.ActionTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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