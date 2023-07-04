package com.faas.core.base.model.ws.flow.content;


import java.util.List;

public class FlowRequest {

    private List<FlowRequest>flowRequests;

    public FlowRequest() {
    }

    public FlowRequest(List<FlowRequest> flowRequests) {
        this.flowRequests = flowRequests;
    }

    public List<FlowRequest> getFlowRequests() {
        return flowRequests;
    }

    public void setFlowRequests(List<FlowRequest> flowRequests) {
        this.flowRequests = flowRequests;
    }
}
