package com.faas.core.base.model.db.operation.details;

import com.faas.core.base.model.db.operation.details.dao.ExecutionResultDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "scenario_execution_table")
public class ScenarioExecutionDBModel {

    @Id
    private String id;
    private long sessionId;
    private long clientId;
    private String campaignId;
    private String processId;
    private String scenarioId;
    private List<ExecutionResultDAO>executionResults;
    private String executionState;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioExecutionDBModel() {
    }

    public ScenarioExecutionDBModel(String id, long sessionId, long clientId, String campaignId, String processId, String scenarioId, List<ExecutionResultDAO> executionResults, String executionState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.scenarioId = scenarioId;
        this.executionResults = executionResults;
        this.executionState = executionState;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    public List<ExecutionResultDAO> getExecutionResults() {
        return executionResults;
    }

    public void setExecutionResults(List<ExecutionResultDAO> executionResults) {
        this.executionResults = executionResults;
    }

    public String getExecutionState() {
        return executionState;
    }

    public void setExecutionState(String executionState) {
        this.executionState = executionState;
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
