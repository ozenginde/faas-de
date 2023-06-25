package com.faas.core.base.model.ws.scenario.details.action.details.dto;

import com.faas.core.base.model.db.scenario.details.action.dao.ActionDataDAO;

public class ActionDataWSDTO {

    private ActionDataDAO actionData;

    public ActionDataWSDTO() {
    }

    public ActionDataWSDTO(ActionDataDAO actionData) {
        this.actionData = actionData;
    }

    public ActionDataDAO getActionData() {
        return actionData;
    }

    public void setActionData(ActionDataDAO actionData) {
        this.actionData = actionData;
    }
}
