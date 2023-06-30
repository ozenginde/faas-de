package com.faas.core.base.model.ws.scenario.details.action.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.action.details.dto.ActionVariableWSDTO;

import java.util.List;

public class ActionVariableWSModel {

    private GeneralWSModel general;
    private List<ActionVariableWSDTO>actionVariables;

    public ActionVariableWSModel() {
    }

    public ActionVariableWSModel(GeneralWSModel general, List<ActionVariableWSDTO> actionVariables) {
        this.general = general;
        this.actionVariables = actionVariables;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionVariableWSDTO> getActionVariables() {
        return actionVariables;
    }

    public void setActionVariables(List<ActionVariableWSDTO> actionVariables) {
        this.actionVariables = actionVariables;
    }
}
