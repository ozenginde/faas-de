package com.faas.core.base.model.db.operation.details;

import com.faas.core.base.model.db.operation.details.dao.ScenarioExecute;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "scenario_execute_table")
public class ScenarioExecuteDBModel {

    @Id
    private String id;
    private long sessionId;
    private String operationId;
    private long agentId;
    private String scenarioId;
    private String scenario;
    private String scenarioType;
    private List<ScenarioExecute>executes;
    private String executeState;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioExecuteDBModel() {
    }

    public ScenarioExecuteDBModel(String id, long sessionId, String operationId, long agentId, String scenarioId, String scenario, String scenarioType, List<ScenarioExecute> executes, String executeState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioType = scenarioType;
        this.executes = executes;
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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
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

    public List<ScenarioExecute> getExecutes() {
        return executes;
    }

    public void setExecutes(List<ScenarioExecute> executes) {
        this.executes = executes;
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
