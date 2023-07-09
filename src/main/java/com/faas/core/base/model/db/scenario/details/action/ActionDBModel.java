package com.faas.core.base.model.db.scenario.details.action;

import com.faas.core.base.model.db.scenario.details.action.dao.ActionVariableDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "action_table")
public class ActionDBModel {

    @Id
    private String id;
    private String scenarioId;
    private String action;
    private long actionTempId;
    private String actionTemp;
    private long actionTypeId;
    private String actionType;
    private List<ActionVariableDAO>actionVariables;
    private int order;
    private long uDate;
    private long cDate;
    private int status;

    public ActionDBModel() {
    }

    public ActionDBModel(String id, String scenarioId, String action, long actionTempId, String actionTemp, long actionTypeId, String actionType, List<ActionVariableDAO> actionVariables, int order, long uDate, long cDate, int status) {
        this.id = id;
        this.scenarioId = scenarioId;
        this.action = action;
        this.actionTempId = actionTempId;
        this.actionTemp = actionTemp;
        this.actionTypeId = actionTypeId;
        this.actionType = actionType;
        this.actionVariables = actionVariables;
        this.order = order;
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

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getActionTempId() {
        return actionTempId;
    }

    public void setActionTempId(long actionTempId) {
        this.actionTempId = actionTempId;
    }

    public String getActionTemp() {
        return actionTemp;
    }

    public void setActionTemp(String actionTemp) {
        this.actionTemp = actionTemp;
    }

    public long getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(long actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public List<ActionVariableDAO> getActionVariables() {
        return actionVariables;
    }

    public void setActionVariables(List<ActionVariableDAO> actionVariables) {
        this.actionVariables = actionVariables;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

