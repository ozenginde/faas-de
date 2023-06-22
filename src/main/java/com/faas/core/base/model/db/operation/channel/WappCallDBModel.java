package com.faas.core.base.model.db.operation.channel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "wapp_call_table")
public class WappCallDBModel {

    @Id
    private String id;
    private String sessionUUID;
    private long sessionId;
    private long clientId;
    private long agentId;
    private String campaignId;
    private String processId;
    private long numberId;
    private String phoneNumber;
    private String wappAccountId;
    private String callerId;
    private String connectionId;
    private String callState;
    private long sDate;
    private long fDate;
    private long uDate;
    private long cDate;
    private int status;


    public WappCallDBModel() {
    }

    public WappCallDBModel(String id, String sessionUUID, long sessionId, long clientId, long agentId, String campaignId, String processId, long numberId, String phoneNumber, String wappAccountId, String callerId, String connectionId, String callState, long sDate, long fDate, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionUUID = sessionUUID;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.wappAccountId = wappAccountId;
        this.callerId = callerId;
        this.connectionId = connectionId;
        this.callState = callState;
        this.sDate = sDate;
        this.fDate = fDate;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionUUID() {
        return sessionUUID;
    }

    public void setSessionUUID(String sessionUUID) {
        this.sessionUUID = sessionUUID;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public long getNumberId() {
        return numberId;
    }

    public void setNumberId(long numberId) {
        this.numberId = numberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWappAccountId() {
        return wappAccountId;
    }

    public void setWappAccountId(String wappAccountId) {
        this.wappAccountId = wappAccountId;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public long getsDate() {
        return sDate;
    }

    public void setsDate(long sDate) {
        this.sDate = sDate;
    }

    public long getfDate() {
        return fDate;
    }

    public void setfDate(long fDate) {
        this.fDate = fDate;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
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
