package com.faas.core.api.model.ws.client.details.dto;

public class ApiClientHookWSDTO {

    private long clientId;

    public ApiClientHookWSDTO() {
    }

    public ApiClientHookWSDTO(long clientId) {
        this.clientId = clientId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
