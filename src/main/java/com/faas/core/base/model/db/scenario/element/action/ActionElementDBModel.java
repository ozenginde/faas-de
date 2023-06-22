package com.faas.core.base.model.db.scenario.element.action;

import com.faas.core.base.model.db.scenario.element.action.dao.ActionElementDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "action_element_table")
public class ActionElementDBModel {

    @Id
    private String id;
    private String scenarioId;
    private String actionName;
    private String actionDesc;
    private long actionTempId;
    private String actionTemp;
    private long actionTypeId;
    private String actionType;
    private List<ActionElementDataDAO>elementDatas;
    private int order;
    private long uDate;
    private long cDate;
    private int status;

    public ActionElementDBModel() {
    }

    public ActionElementDBModel(String id, String scenarioId, String actionName, String actionDesc, long actionTempId, String actionTemp, long actionTypeId, String actionType, List<ActionElementDataDAO> elementDatas, int order, long uDate, long cDate, int status) {
        this.id = id;
        this.scenarioId = scenarioId;
        this.actionName = actionName;
        this.actionDesc = actionDesc;
        this.actionTempId = actionTempId;
        this.actionTemp = actionTemp;
        this.actionTypeId = actionTypeId;
        this.actionType = actionType;
        this.elementDatas = elementDatas;
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

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
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

    public List<ActionElementDataDAO> getElementDatas() {
        return elementDatas;
    }

    public void setElementDatas(List<ActionElementDataDAO> elementDatas) {
        this.elementDatas = elementDatas;
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
