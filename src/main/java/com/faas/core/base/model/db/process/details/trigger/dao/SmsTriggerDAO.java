package com.faas.core.base.model.db.process.details.trigger.dao;

public class SmsTriggerDAO {

    private String id;
    private String accountId;
    private String account;
    private String title;
    private String body;
    private String senderId;
    private String messageType;
    private long cDate;
    private int status;

    public SmsTriggerDAO() {
    }

    public SmsTriggerDAO(String id, String accountId, String account, String title, String body, String senderId, String messageType, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.account = account;
        this.title = title;
        this.body = body;
        this.senderId = senderId;
        this.messageType = messageType;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
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
