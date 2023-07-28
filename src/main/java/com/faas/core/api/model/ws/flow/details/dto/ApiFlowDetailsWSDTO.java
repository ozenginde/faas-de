package com.faas.core.api.model.ws.flow.details.dto;

import com.faas.core.api.model.ws.campaign.details.process.content.dto.ApiProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiFlowDetailsWSDTO {

    private GeneralWSModel general;
    private List<ApiProcessWSDTO>processes;


    public ApiFlowDetailsWSDTO() {
    }

    public ApiFlowDetailsWSDTO(GeneralWSModel general, List<ApiProcessWSDTO> processes) {
        this.general = general;
        this.processes = processes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiProcessWSDTO> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ApiProcessWSDTO> processes) {
        this.processes = processes;
    }
}
