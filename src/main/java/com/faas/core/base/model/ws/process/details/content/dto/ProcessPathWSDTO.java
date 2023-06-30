package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessPathDAO;

public class ProcessPathWSDTO {

    private ProcessPathDAO processPath;

    public ProcessPathWSDTO() {
    }

    public ProcessPathWSDTO(ProcessPathDAO processPath) {
        this.processPath = processPath;
    }

    public ProcessPathDAO getProcessPath() {
        return processPath;
    }

    public void setProcessPath(ProcessPathDAO processPath) {
        this.processPath = processPath;
    }
}
