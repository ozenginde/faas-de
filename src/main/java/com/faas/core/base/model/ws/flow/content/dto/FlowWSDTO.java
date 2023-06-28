package com.faas.core.base.model.ws.flow.content.dto;

import com.faas.core.base.model.db.flow.content.FlowDBModel;

public class FlowWSDTO {

    private FlowDBModel flow;

    public FlowWSDTO() {
    }

    public FlowWSDTO(FlowDBModel flow) {
        this.flow = flow;
    }

    public FlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(FlowDBModel flow) {
        this.flow = flow;
    }
}
