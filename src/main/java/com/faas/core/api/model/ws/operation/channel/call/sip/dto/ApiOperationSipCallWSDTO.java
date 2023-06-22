package com.faas.core.api.model.ws.operation.channel.call.sip.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;

import java.util.List;

public class ApiOperationSipCallWSDTO {

    private ApiSipAccountWSDTO sipAccount;
    private List<ClientPhoneDBModel>phones;
    private SipCallDBModel sipCall;
    private List<SipCallDBModel>sipCalls;

    public ApiOperationSipCallWSDTO() {
    }

    public ApiOperationSipCallWSDTO(ApiSipAccountWSDTO sipAccount, List<ClientPhoneDBModel> phones, SipCallDBModel sipCall, List<SipCallDBModel> sipCalls) {
        this.sipAccount = sipAccount;
        this.phones = phones;
        this.sipCall = sipCall;
        this.sipCalls = sipCalls;
    }

    public ApiSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }

    public List<ClientPhoneDBModel> getPhones() {
        return phones;
    }

    public void setPhones(List<ClientPhoneDBModel> phones) {
        this.phones = phones;
    }

    public SipCallDBModel getSipCall() {
        return sipCall;
    }

    public void setSipCall(SipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }

    public List<SipCallDBModel> getSipCalls() {
        return sipCalls;
    }

    public void setSipCalls(List<SipCallDBModel> sipCalls) {
        this.sipCalls = sipCalls;
    }
}
