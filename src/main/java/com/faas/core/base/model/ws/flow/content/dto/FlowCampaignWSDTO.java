package com.faas.core.base.model.ws.flow.content.dto;

import com.faas.core.base.model.db.flow.FlowDBModel;

public class FlowCampaignWSDTO {

    private FlowDBModel flow;

    public FlowCampaignWSDTO() {
    }

    public FlowCampaignWSDTO(FlowDBModel flow) {
        this.flow = flow;
    }

    public FlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(FlowDBModel flow) {
        this.flow = flow;
    }
}
