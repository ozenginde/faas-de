package com.faas.core.base.model.db.operation.scenario;

import com.faas.core.base.model.db.operation.scenario.dao.ElementExecutionDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "scenario_execution_table")
public class ScenarioExecutionDBModel {

    @Id
    private String id;
    private long sessionId;
    private long agentId;
    private String operationId;
    private String campaignId;
    private String processId;
    private String scenarioId;
    private String scenario;
    private String scenarioType;
    private String baseType;
    private List<ElementExecutionDAO> executions;
    private String executionState;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioExecutionDBModel() {
    }

    public ScenarioExecutionDBModel(String id, long sessionId, long agentId, String operationId, String campaignId, String processId, String scenarioId, String scenario, String scenarioType, String baseType, List<ElementExecutionDAO> executions, String executionState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.operationId = operationId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioType = scenarioType;
        this.baseType = baseType;
        this.executions = executions;
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

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
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

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getScenarioType() {
        return scenarioType;
    }

    public void setScenarioType(String scenarioType) {
        this.scenarioType = scenarioType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<ElementExecutionDAO> getExecutions() {
        return executions;
    }

    public void setExecutions(List<ElementExecutionDAO> executions) {
        this.executions = executions;
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
