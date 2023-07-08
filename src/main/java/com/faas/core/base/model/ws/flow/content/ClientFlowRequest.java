package com.faas.core.base.model.ws.flow.content;


import com.faas.core.base.model.ws.flow.content.dto.ClientFlowRequestDTO;

import java.util.List;

public class ClientFlowRequest {

    private List<ClientFlowRequestDTO> flowRequests;

    public ClientFlowRequest() {
    }

    public ClientFlowRequest(List<ClientFlowRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }

    public List<ClientFlowRequestDTO> getFlowRequests() {
        return flowRequests;
    }

    public void setFlowRequests(List<ClientFlowRequestDTO> flowRequests) {
        this.flowRequests = flowRequests;
    }
}
