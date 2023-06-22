package com.faas.core.base.model.db.operation.scenario;

import com.faas.core.base.model.db.operation.scenario.dao.ScenarioElementDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "scenario_execute_table")
public class ScenarioExecuteDBModel {

    @Id
    private String id;
    private String operationId;
    private long sessionId;
    private long clientId;
    private String sessionUUID;
    private String campaignId;
    private String processId;
    private String scenarioId;
    private long agentId;
    private List<ScenarioElementDAO> scenarioElements;
    private String executeState;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioExecuteDBModel() {
    }

    public ScenarioExecuteDBModel(String id, String operationId, long sessionId, long clientId, String sessionUUID, String campaignId, String processId, String scenarioId, long agentId, List<ScenarioElementDAO> scenarioElements, String executeState, long uDate, long cDate, int status) {
        this.id = id;
        this.operationId = operationId;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.sessionUUID = sessionUUID;
        this.campaignId = campaignId;
        this.processId = processId;
        this.scenarioId = scenarioId;
        this.agentId = agentId;
        this.scenarioElements = scenarioElements;
        this.executeState = executeState;
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

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
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

    public String getSessionUUID() {
        return sessionUUID;
    }

    public void setSessionUUID(String sessionUUID) {
        this.sessionUUID = sessionUUID;
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

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public List<ScenarioElementDAO> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ScenarioElementDAO> scenarioElements) {
        this.scenarioElements = scenarioElements;
    }

    public String getExecuteState() {
        return executeState;
    }

    public void setExecuteState(String executeState) {
        this.executeState = executeState;
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
