package com.faas.core.base.model.ws.scenario.element.automation.details.dto;

import com.faas.core.base.model.db.scenario.element.automation.dao.AutomationElementDataDAO;

public class AutomationElementDataWSDTO {

    private AutomationElementDataDAO elementData;

    public AutomationElementDataWSDTO() {
    }

    public AutomationElementDataWSDTO(AutomationElementDataDAO elementData) {
        this.elementData = elementData;
    }

    public AutomationElementDataDAO getElementData() {
        return elementData;
    }

    public void setElementData(AutomationElementDataDAO elementData) {
        this.elementData = elementData;
    }
}
