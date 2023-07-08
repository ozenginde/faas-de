package com.faas.core.base.model.ws.flow.details;

import com.faas.core.base.model.ws.flow.details.dto.ClientFlowDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ClientFlowDetailsWSModel {

    private GeneralWSModel general;
    private ClientFlowDetailsWSDTO flowDetails;

    public ClientFlowDetailsWSModel() {
    }

    public ClientFlowDetailsWSModel(GeneralWSModel general, ClientFlowDetailsWSDTO flowDetails) {
        this.general = general;
        this.flowDetails = flowDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientFlowDetailsWSDTO getFlowDetails() {
        return flowDetails;
    }

    public void setFlowDetails(ClientFlowDetailsWSDTO flowDetails) {
        this.flowDetails = flowDetails;
    }
}
