package com.faas.core.base.model.db.operation.content;

import com.faas.core.base.model.db.operation.content.dao.OperationActivityDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "operation_table")
public class OperationDBModel {

    @Id
    private String id;
    private long sessionId;
    private String sessionUUID;
    private long clientId;
    private long agentId;
    private String campaignId;
    private String processId;
    private List<OperationActivityDAO>activities;
    private String operationState;
    private String operationResult;
    private long uDate;
    private long cDate;
    private int status;

    public OperationDBModel() {
    }

    public OperationDBModel(String id, long sessionId, String sessionUUID, long clientId, long agentId, String campaignId, String processId, List<OperationActivityDAO> activities, String operationState, String operationResult, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.sessionUUID = sessionUUID;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.activities = activities;
        this.operationState = operationState;
        this.operationResult = operationResult;
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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionUUID() {
        return sessionUUID;
    }

    public void setSessionUUID(String sessionUUID) {
        this.sessionUUID = sessionUUID;
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

    public List<OperationActivityDAO> getActivities() {
        return activities;
    }

    public void setActivities(List<OperationActivityDAO> activities) {
        this.activities = activities;
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
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
