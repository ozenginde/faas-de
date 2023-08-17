package com.faas.core.base.model.db.operation.channel.dao;


public class SmsMessageDAO {

    private String tempId;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private String messageType;
    private String accountId;

    public SmsMessageDAO() {
    }

    public SmsMessageDAO(String tempId, String smsTitle, String smsBody, String senderId, String messageType, String accountId) {
        this.tempId = tempId;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
        this.messageType = messageType;
        this.accountId = accountId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
