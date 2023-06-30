package com.faas.core.base.model.ws.scenario.details.action.details.dto;

import com.faas.core.base.model.db.scenario.details.action.dao.ActionVariableDAO;

public class ActionVariableWSDTO {

    private ActionVariableDAO actionVariable;

    public ActionVariableWSDTO() {
    }

    public ActionVariableWSDTO(ActionVariableDAO actionVariable) {
        this.actionVariable = actionVariable;
    }

    public ActionVariableDAO getActionVariable() {
        return actionVariable;
    }

    public void setActionVariable(ActionVariableDAO actionVariable) {
        this.actionVariable = actionVariable;
    }
}
