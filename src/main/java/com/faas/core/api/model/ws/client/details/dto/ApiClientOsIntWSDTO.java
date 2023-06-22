package com.faas.core.api.model.ws.client.details.dto;

public class ApiClientOsIntWSDTO {

    private long clientId;

    public ApiClientOsIntWSDTO() {
    }

    public ApiClientOsIntWSDTO(long clientId) {
        this.clientId = clientId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
