package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessCallScriptWSDTO;

import java.util.List;

public class ProcessCallScriptWSModel {

    private GeneralWSModel general;
    private List<ProcessCallScriptWSDTO>callScripts;

    public ProcessCallScriptWSModel() {
    }

    public ProcessCallScriptWSModel(GeneralWSModel general, List<ProcessCallScriptWSDTO> callScripts) {
        this.general = general;
        this.callScripts = callScripts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessCallScriptWSDTO> getCallScripts() {
        return callScripts;
    }

    public void setCallScripts(List<ProcessCallScriptWSDTO> callScripts) {
        this.callScripts = callScripts;
    }
}
