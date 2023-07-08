package com.faas.core.base.model.ws.flow.content.dto;

import com.faas.core.base.model.db.flow.ClientFlowDBModel;

public class ClientFlowWSDTO {

    private ClientFlowDBModel clientFlow;

    public ClientFlowWSDTO() {
    }

    public ClientFlowWSDTO(ClientFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }

    public ClientFlowDBModel getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(ClientFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }
}
