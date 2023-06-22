package com.faas.core.api.model.ws.client.details.dto;

import com.faas.core.api.model.ws.session.details.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientAddressDBModel;
import com.faas.core.base.model.db.client.details.ClientDataDBModel;
import com.faas.core.base.model.db.client.details.ClientEmailDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;

import java.util.List;

public class ApiClientDetailsWSDTO {

    private ClientDBModel client;
    private List<ClientDataDBModel> clientDatas;
    private List<ClientAddressDBModel>clientAddresses;
    private List<ClientPhoneDBModel>clientPhones;
    private List<ClientEmailDBModel>clientEmails;
    private List<ApiSessionDetailsWSDTO> clientSessions;

    public ApiClientDetailsWSDTO() {
    }

    public ApiClientDetailsWSDTO(ClientDBModel client, List<ClientDataDBModel> clientDatas, List<ClientAddressDBModel> clientAddresses, List<ClientPhoneDBModel> clientPhones, List<ClientEmailDBModel> clientEmails, List<ApiSessionDetailsWSDTO> clientSessions) {
        this.client = client;
        this.clientDatas = clientDatas;
        this.clientAddresses = clientAddresses;
        this.clientPhones = clientPhones;
        this.clientEmails = clientEmails;
        this.clientSessions = clientSessions;
    }

    public ClientDBModel getClient() {
        return client;
    }

    public void setClient(ClientDBModel client) {
        this.client = client;
    }

    public List<ClientDataDBModel> getClientDatas() {
        return clientDatas;
    }

    public void setClientDatas(List<ClientDataDBModel> clientDatas) {
        this.clientDatas = clientDatas;
    }

    public List<ClientAddressDBModel> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddressDBModel> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    public List<ClientPhoneDBModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDBModel> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientEmailDBModel> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailDBModel> clientEmails) {
        this.clientEmails = clientEmails;
    }

    public List<ApiSessionDetailsWSDTO> getClientSessions() {
        return clientSessions;
    }

    public void setClientSessions(List<ApiSessionDetailsWSDTO> clientSessions) {
        this.clientSessions = clientSessions;
    }
}
