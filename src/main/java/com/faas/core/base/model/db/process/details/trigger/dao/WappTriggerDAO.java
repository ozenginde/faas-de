package com.faas.core.base.model.db.process.details.trigger.dao;


import java.util.List;

public class WappTriggerDAO {

    private String id;
    private String accountId;
    private String account;
    private String title;
    private String body;
    private List<TriggerDataDAO>triggerDatas;
    private String messageType;
    private long cDate;
    private int status;

    public WappTriggerDAO() {
    }

    public WappTriggerDAO(String id, String accountId, String account, String title, String body, List<TriggerDataDAO> triggerDatas, String messageType, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.account = account;
        this.title = title;
        this.body = body;
        this.triggerDatas = triggerDatas;
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

    public List<TriggerDataDAO> getTriggerDatas() {
        return triggerDatas;
    }

    public void setTriggerDatas(List<TriggerDataDAO> triggerDatas) {
        this.triggerDatas = triggerDatas;
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
