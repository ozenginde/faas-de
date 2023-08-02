package com.faas.core.api.model.ws.operation.details.client.osint.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;

public class ApiClientOsIntWSDTO {

    private ClientDBModel client;

    public ApiClientOsIntWSDTO() {
    }

    public ApiClientOsIntWSDTO(ClientDBModel client) {
        this.client = client;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }
}
