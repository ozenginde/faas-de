package com.faas.core.api.model.ws.operation.channel.call.sip.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;

import java.util.List;

public class ApiOperationSipCallWSDTO {

    private ApiSipAccountWSDTO sipAccount;
    private List<ClientPhoneDBModel>clientPhones;
    private SipCallDBModel currentSipCall;
    private SipCallDBModel recentSipCalls;

    public ApiOperationSipCallWSDTO() {
    }

    public ApiOperationSipCallWSDTO(ApiSipAccountWSDTO sipAccount, List<ClientPhoneDBModel> clientPhones, SipCallDBModel currentSipCall, SipCallDBModel recentSipCalls) {
        this.sipAccount = sipAccount;
        this.clientPhones = clientPhones;
        this.currentSipCall = currentSipCall;
        this.recentSipCalls = recentSipCalls;
    }

    public ApiSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }

    public List<ClientPhoneDBModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneDBModel> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public SipCallDBModel getCurrentSipCall() {
        return currentSipCall;
    }

    public void setCurrentSipCall(SipCallDBModel currentSipCall) {
        this.currentSipCall = currentSipCall;
    }

    public SipCallDBModel getRecentSipCalls() {
        return recentSipCalls;
    }

    public void setRecentSipCalls(SipCallDBModel recentSipCalls) {
        this.recentSipCalls = recentSipCalls;
    }
}
