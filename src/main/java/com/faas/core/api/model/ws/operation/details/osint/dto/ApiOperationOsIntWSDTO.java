package com.faas.core.api.model.ws.operation.details.osint.dto;

import com.faas.core.base.model.db.client.content.ClientDBModel;

public class ApiOperationOsIntWSDTO {

    private ClientDBModel client;

    public ApiOperationOsIntWSDTO() {
    }

    public ApiOperationOsIntWSDTO(ClientDBModel client) {
        this.client = client;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }
}
