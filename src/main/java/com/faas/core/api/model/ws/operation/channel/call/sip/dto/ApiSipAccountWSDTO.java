package com.faas.core.api.model.ws.operation.channel.call.sip.dto;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ApiSipAccountWSDTO {

    private String accountId;
    private String account;
    private String userName;
    private String authUser;
    private String password;
    private String sipUrl;
    private List<AccountDataDAO> accountDatas;
    private String provider;
    private String callerId;
    private String sipStatus;
    private long cDate;
    private int status;

    public ApiSipAccountWSDTO() {
    }

    public ApiSipAccountWSDTO(String accountId, String account, String userName, String authUser, String password, String sipUrl, List<AccountDataDAO> accountDatas, String provider, String callerId, String sipStatus, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.userName = userName;
        this.authUser = authUser;
        this.password = password;
        this.sipUrl = sipUrl;
        this.accountDatas = accountDatas;
        this.provider = provider;
        this.callerId = callerId;
        this.sipStatus = sipStatus;
        this.cDate = cDate;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthUser() {
        return authUser;
    }

    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSipUrl() {
        return sipUrl;
    }

    public void setSipUrl(String sipUrl) {
        this.sipUrl = sipUrl;
    }

    public List<AccountDataDAO> getAccountDatas() {
        return accountDatas;
    }

    public void setAccountDatas(List<AccountDataDAO> accountDatas) {
        this.accountDatas = accountDatas;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getSipStatus() {
        return sipStatus;
    }

    public void setSipStatus(String sipStatus) {
        this.sipStatus = sipStatus;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
