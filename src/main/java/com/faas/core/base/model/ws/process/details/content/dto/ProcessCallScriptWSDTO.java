package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessCallScriptDAO;

public class ProcessCallScriptWSDTO {

    private ProcessCallScriptDAO callScript;

    public ProcessCallScriptWSDTO() {
    }

    public ProcessCallScriptWSDTO(ProcessCallScriptDAO callScript) {
        this.callScript = callScript;
    }

    public ProcessCallScriptDAO getCallScript() {
        return callScript;
    }

    public void setCallScript(ProcessCallScriptDAO callScript) {
        this.callScript = callScript;
    }
}
