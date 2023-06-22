package com.faas.core.base.model.ws.client.content;

import com.faas.core.base.model.ws.client.content.dto.CreateClientRequestWSDTO;

import java.util.List;

public class CreateClientRequestModel {

    private List<CreateClientRequestWSDTO>clientRequests;

    public CreateClientRequestModel() {
    }

    public CreateClientRequestModel(List<CreateClientRequestWSDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }

    public List<CreateClientRequestWSDTO> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<CreateClientRequestWSDTO> clientRequests) {
        this.clientRequests = clientRequests;
    }

}
