package com.faas.core.base.model.ws.action.content.dto;

import com.faas.core.base.model.db.action.content.ActionTempDBModel;

public class ActionTempWSDTO {

    private ActionTempDBModel actionTemp;

    public ActionTempWSDTO() {
    }

    public ActionTempWSDTO(ActionTempDBModel actionTemp) {
        this.actionTemp = actionTemp;
    }

    public ActionTempDBModel getActionTemp() {
        return actionTemp;
    }

    public void setActionTemp(ActionTempDBModel actionTemp) {
        this.actionTemp = actionTemp;
    }
}
