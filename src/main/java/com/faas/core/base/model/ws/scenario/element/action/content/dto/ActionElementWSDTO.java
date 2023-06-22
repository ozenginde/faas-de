package com.faas.core.base.model.ws.scenario.element.action.content.dto;

import com.faas.core.base.model.db.scenario.element.action.ActionElementDBModel;

public class ActionElementWSDTO {

    private ActionElementDBModel actionElement;

    public ActionElementWSDTO() {
    }

    public ActionElementWSDTO(ActionElementDBModel actionElement) {
        this.actionElement = actionElement;
    }

    public ActionElementDBModel getActionElement() {
        return actionElement;
    }

    public void setActionElement(ActionElementDBModel actionElement) {
        this.actionElement = actionElement;
    }
}
