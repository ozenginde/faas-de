package com.faas.core.base.model.ws.scenario.details.action.content.dto;

import com.faas.core.base.model.db.scenario.details.action.ActionDBModel;

public class ActionWSDTO {

    private ActionDBModel action;

    public ActionWSDTO() {
    }

    public ActionWSDTO(ActionDBModel action) {
        this.action = action;
    }

    public ActionDBModel getAction() {
        return action;
    }

    public void setAction(ActionDBModel action) {
        this.action = action;
    }
}
