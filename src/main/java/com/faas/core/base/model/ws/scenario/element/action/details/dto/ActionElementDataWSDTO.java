package com.faas.core.base.model.ws.scenario.element.action.details.dto;

import com.faas.core.base.model.db.scenario.element.action.dao.ActionElementDataDAO;

public class ActionElementDataWSDTO {

    private ActionElementDataDAO elementData;

    public ActionElementDataWSDTO() {
    }

    public ActionElementDataWSDTO(ActionElementDataDAO elementData) {
        this.elementData = elementData;
    }

    public ActionElementDataDAO getElementData() {
        return elementData;
    }

    public void setElementData(ActionElementDataDAO elementData) {
        this.elementData = elementData;
    }
}
