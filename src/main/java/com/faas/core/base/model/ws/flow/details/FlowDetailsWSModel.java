package com.faas.core.base.model.ws.flow.details;

import com.faas.core.base.model.ws.flow.details.dto.FlowDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.inquiry.content.dto.InquiryWSDTO;

import java.util.List;

public class FlowDetailsWSModel {

    private GeneralWSModel general;
    private FlowDetailsWSDTO flowDetails;

    public FlowDetailsWSModel() {
    }

    public FlowDetailsWSModel(GeneralWSModel general, FlowDetailsWSDTO flowDetails) {
        this.general = general;
        this.flowDetails = flowDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public FlowDetailsWSDTO getFlowDetails() {
        return flowDetails;
    }

    public void setFlowDetails(FlowDetailsWSDTO flowDetails) {
        this.flowDetails = flowDetails;
    }
}
