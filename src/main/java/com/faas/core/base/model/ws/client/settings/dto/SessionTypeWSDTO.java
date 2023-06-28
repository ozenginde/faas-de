package com.faas.core.base.model.ws.client.settings.dto;

import com.faas.core.base.model.db.client.settings.FlowTypeDBModel;

public class SessionTypeWSDTO {

    private FlowTypeDBModel flowType;

    public SessionTypeWSDTO() {
    }

    public SessionTypeWSDTO(FlowTypeDBModel flowType) {
        this.flowType = flowType;
    }

    public FlowTypeDBModel getFlowType() {
        return flowType;
    }

    public void setFlowType(FlowTypeDBModel flowType) {
        this.flowType = flowType;
    }
}
