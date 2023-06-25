package com.faas.core.base.model.db.scenario.element.automation;

import com.faas.core.base.model.db.scenario.element.automation.dao.AutomationVariableDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "automation_table")
public class AutomationDBModel {

    @Id
    private String id;
    private String scenarioId;
    private String automation;
    private String automationDesc;
    private long automationTempId;
    private String automationTemp;
    private long automationTypeId;
    private String automationType;
    private String baseType;
    private List<AutomationVariableDAO>automationVariables;
    private int order;
    private long uDate;
    private long cDate;
    private int status;

    public AutomationDBModel() {
    }

    public AutomationDBModel(String id, String scenarioId, String automation, String automationDesc, long automationTempId, String automationTemp, long automationTypeId, String automationType, String baseType, List<AutomationVariableDAO> automationVariables, int order, long uDate, long cDate, int status) {
        this.id = id;
        this.scenarioId = scenarioId;
        this.automation = automation;
        this.automationDesc = automationDesc;
        this.automationTempId = automationTempId;
        this.automationTemp = automationTemp;
        this.automationTypeId = automationTypeId;
        this.automationType = automationType;
        this.baseType = baseType;
        this.automationVariables = automationVariables;
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

    public String getAutomation() {
        return automation;
    }

    public void setAutomation(String automation) {
        this.automation = automation;
    }

    public String getAutomationDesc() {
        return automationDesc;
    }

    public void setAutomationDesc(String automationDesc) {
        this.automationDesc = automationDesc;
    }

    public long getAutomationTempId() {
        return automationTempId;
    }

    public void setAutomationTempId(long automationTempId) {
        this.automationTempId = automationTempId;
    }

    public String getAutomationTemp() {
        return automationTemp;
    }

    public void setAutomationTemp(String automationTemp) {
        this.automationTemp = automationTemp;
    }

    public long getAutomationTypeId() {
        return automationTypeId;
    }

    public void setAutomationTypeId(long automationTypeId) {
        this.automationTypeId = automationTypeId;
    }

    public String getAutomationType() {
        return automationType;
    }

    public void setAutomationType(String automationType) {
        this.automationType = automationType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<AutomationVariableDAO> getAutomationVariables() {
        return automationVariables;
    }

    public void setAutomationVariables(List<AutomationVariableDAO> automationVariables) {
        this.automationVariables = automationVariables;
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
