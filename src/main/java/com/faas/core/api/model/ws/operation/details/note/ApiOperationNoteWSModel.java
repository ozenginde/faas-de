package com.faas.core.api.model.ws.operation.details.note;

import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;



public class ApiOperationNoteWSModel {

    private GeneralWSModel general;
    private ApiOperationNoteWSDTO operationNote;

    public ApiOperationNoteWSModel() {
    }

    public ApiOperationNoteWSModel(GeneralWSModel general, ApiOperationNoteWSDTO operationNote) {
        this.general = general;
        this.operationNote = operationNote;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationNoteWSDTO getOperationNote() {
        return operationNote;
    }

    public void setOperationNote(ApiOperationNoteWSDTO operationNote) {
        this.operationNote = operationNote;
    }
}
