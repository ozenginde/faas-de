package com.faas.core.base.model.ws.action.settings.dto;

import com.faas.core.base.model.db.action.settings.ActionTypeDBModel;

public class ActionTypeWSDTO {

    private ActionTypeDBModel actionType;

    public ActionTypeWSDTO() {
    }

    public ActionTypeWSDTO(ActionTypeDBModel actionType) {
        this.actionType = actionType;
    }

    public ActionTypeDBModel getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeDBModel actionType) {
        this.actionType = actionType;
    }
}
