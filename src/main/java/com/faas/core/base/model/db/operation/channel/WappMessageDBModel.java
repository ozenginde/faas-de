package com.faas.core.base.model.db.operation.channel;

import com.faas.core.base.model.db.operation.channel.dao.WappMessageDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "wapp_message_table")
public class WappMessageDBModel {

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
    private String tempId;
    private String title;
    private String body;
    private List<WappMessageDataDAO>messageDatas;
    private String messageType;
    private String wappAccountId;
    private String senderId;
    private String sentId;
    private String messageState;
    private long uDate;
    private long cDate;
    private int status;

    public WappMessageDBModel() {
    }

    public WappMessageDBModel(String id, String sessionUUID, long sessionId, long clientId, long agentId, String campaignId, String processId, long numberId, String phoneNumber, String tempId, String title, String body, List<WappMessageDataDAO> messageDatas, String messageType, String wappAccountId, String senderId, String sentId, String messageState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionUUID = sessionUUID;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.tempId = tempId;
        this.title = title;
        this.body = body;
        this.messageDatas = messageDatas;
        this.messageType = messageType;
        this.wappAccountId = wappAccountId;
        this.senderId = senderId;
        this.sentId = sentId;
        this.messageState = messageState;
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

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
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

    public List<WappMessageDataDAO> getMessageDatas() {
        return messageDatas;
    }

    public void setMessageDatas(List<WappMessageDataDAO> messageDatas) {
        this.messageDatas = messageDatas;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getWappAccountId() {
        return wappAccountId;
    }

    public void setWappAccountId(String wappAccountId) {
        this.wappAccountId = wappAccountId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSentId() {
        return sentId;
    }

    public void setSentId(String sentId) {
        this.sentId = sentId;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
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
