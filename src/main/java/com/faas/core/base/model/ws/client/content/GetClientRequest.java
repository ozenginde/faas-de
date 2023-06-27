package com.faas.core.base.model.ws.client.content;

import com.faas.core.base.model.ws.client.content.dto.GetClientRequestDTO;

import java.util.List;

public class GetClientRequest {

    private List<GetClientRequestDTO> getClients;

    public GetClientRequest() {
    }

    public GetClientRequest(List<GetClientRequestDTO> getClients) {
        this.getClients = getClients;
    }

    public List<GetClientRequestDTO> getGetClients() {
        return getClients;
    }

    public void setGetClients(List<GetClientRequestDTO> getClients) {
        this.getClients = getClients;
    }
}
