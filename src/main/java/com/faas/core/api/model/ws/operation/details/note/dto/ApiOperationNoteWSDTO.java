package com.faas.core.api.model.ws.operation.details.note.dto;

import com.faas.core.base.model.db.client.details.ClientNoteDBModel;

import java.util.List;

public class ApiOperationNoteWSDTO {

    private List<ClientNoteDBModel> clientNotes;

    public ApiOperationNoteWSDTO() {
    }

    public ApiOperationNoteWSDTO(List<ClientNoteDBModel> clientNotes) {
        this.clientNotes = clientNotes;
    }

    public List<ClientNoteDBModel> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ClientNoteDBModel> clientNotes) {
        this.clientNotes = clientNotes;
    }
}
