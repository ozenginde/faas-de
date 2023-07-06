package com.faas.core.base.model.ws.flow.manager.dto;

import com.faas.core.base.model.db.flow.FlowDBModel;

public class FlowManagerWSDTO {

    private FlowDBModel flow;

    public FlowManagerWSDTO() {
    }

    public FlowManagerWSDTO(FlowDBModel flow) {
        this.flow = flow;
    }

    public FlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(FlowDBModel flow) {
        this.flow = flow;
    }
}
