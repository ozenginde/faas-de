package com.faas.core.api.model.ws.operation.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;

import java.util.List;

public class ApiWappCallWSDTO {

    private List<ClientPhoneDBModel> phones;
    private WappCallDBModel wappCall;
    private List<WappCallDBModel>wappCalls;

    public ApiWappCallWSDTO() {
    }

    public ApiWappCallWSDTO(List<ClientPhoneDBModel> phones, WappCallDBModel wappCall, List<WappCallDBModel> wappCalls) {
        this.phones = phones;
        this.wappCall = wappCall;
        this.wappCalls = wappCalls;
    }

    public List<ClientPhoneDBModel> getPhones() {
        return phones;
    }

    public void setPhones(List<ClientPhoneDBModel> phones) {
        this.phones = phones;
    }

    public WappCallDBModel getWappCall() {
        return wappCall;
    }

    public void setWappCall(WappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }

    public List<WappCallDBModel> getWappCalls() {
        return wappCalls;
    }

    public void setWappCalls(List<WappCallDBModel> wappCalls) {
        this.wappCalls = wappCalls;
    }
}
