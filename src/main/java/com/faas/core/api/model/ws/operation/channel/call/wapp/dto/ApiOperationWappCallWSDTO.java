package com.faas.core.api.model.ws.operation.channel.call.wapp.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;

import java.util.List;

public class ApiOperationWappCallWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ClientPhoneDBModel>phones;
    private WappCallDBModel wappCall;
    private List<WappCallDBModel>wappCalls;

    public ApiOperationWappCallWSDTO() {
    }

    public ApiOperationWappCallWSDTO(ApiWappAccountWSDTO wappAccount, List<ClientPhoneDBModel> phones, WappCallDBModel wappCall, List<WappCallDBModel> wappCalls) {
        this.wappAccount = wappAccount;
        this.phones = phones;
        this.wappCall = wappCall;
        this.wappCalls = wappCalls;
    }

    public ApiWappAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
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
