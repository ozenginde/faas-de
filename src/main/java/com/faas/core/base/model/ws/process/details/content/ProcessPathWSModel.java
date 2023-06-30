package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessPathWSDTO;

import java.util.List;

public class ProcessPathWSModel {

    private GeneralWSModel general;
    private List<ProcessPathWSDTO>processPaths;

    public ProcessPathWSModel() {
    }

    public ProcessPathWSModel(GeneralWSModel general, List<ProcessPathWSDTO> processPaths) {
        this.general = general;
        this.processPaths = processPaths;
    }


    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessPathWSDTO> getProcessPaths() {
        return processPaths;
    }

    public void setProcessPaths(List<ProcessPathWSDTO> processPaths) {
        this.processPaths = processPaths;
    }
}
