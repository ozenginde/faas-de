package com.faas.core.base.model.ws.flow.details.dto;

import com.faas.core.base.model.db.flow.ClientFlowDBModel;

public class ClientFlowDetailsWSDTO {

    private ClientFlowDBModel flow;

    public ClientFlowDetailsWSDTO() {
    }

    public ClientFlowDetailsWSDTO(ClientFlowDBModel flow) {
        this.flow = flow;
    }

    public ClientFlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(ClientFlowDBModel flow) {
        this.flow = flow;
    }
}
