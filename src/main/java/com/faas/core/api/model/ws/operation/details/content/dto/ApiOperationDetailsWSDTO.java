package com.faas.core.api.model.ws.operation.details.content.dto;

import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.osint.dto.ApiOperationOsIntWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

import java.util.List;

public class ApiOperationDetailsWSDTO {

    private OperationDBModel operation;
    private SessionDBModel operationSession;
    private ApiOperationClientWSDTO operationClient;
    private ApiOperationOsIntWSDTO operationOsInt;
    private ApiOperationNoteWSDTO operationNote;
    private List<ApiOperationActivityWSDTO> operationActivities;
    private ApiOperationCampaignWSDTO operationCampaign;
    private ApiOperationScenarioWSDTO operationScenario;
    private ApiOperationChannelWSDTO operationChannel;

    public ApiOperationDetailsWSDTO() {
    }

    public ApiOperationDetailsWSDTO(OperationDBModel operation, SessionDBModel operationSession, ApiOperationClientWSDTO operationClient, ApiOperationOsIntWSDTO operationOsInt, ApiOperationNoteWSDTO operationNote, List<ApiOperationActivityWSDTO> operationActivities, ApiOperationCampaignWSDTO operationCampaign, ApiOperationScenarioWSDTO operationScenario, ApiOperationChannelWSDTO operationChannel) {
        this.operation = operation;
        this.operationSession = operationSession;
        this.operationClient = operationClient;
        this.operationOsInt = operationOsInt;
        this.operationNote = operationNote;
        this.operationActivities = operationActivities;
        this.operationCampaign = operationCampaign;
        this.operationScenario = operationScenario;
        this.operationChannel = operationChannel;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }

    public SessionDBModel getOperationSession() {
        return operationSession;
    }

    public void setOperationSession(SessionDBModel operationSession) {
        this.operationSession = operationSession;
    }

    public ApiOperationClientWSDTO getOperationClient() {
        return operationClient;
    }

    public void setOperationClient(ApiOperationClientWSDTO operationClient) {
        this.operationClient = operationClient;
    }

    public ApiOperationOsIntWSDTO getOperationOsInt() {
        return operationOsInt;
    }

    public void setOperationOsInt(ApiOperationOsIntWSDTO operationOsInt) {
        this.operationOsInt = operationOsInt;
    }

    public ApiOperationNoteWSDTO getOperationNote() {
        return operationNote;
    }

    public void setOperationNote(ApiOperationNoteWSDTO operationNote) {
        this.operationNote = operationNote;
    }

    public List<ApiOperationActivityWSDTO> getOperationActivities() {
        return operationActivities;
    }

    public void setOperationActivities(List<ApiOperationActivityWSDTO> operationActivities) {
        this.operationActivities = operationActivities;
    }

    public ApiOperationCampaignWSDTO getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(ApiOperationCampaignWSDTO operationCampaign) {
        this.operationCampaign = operationCampaign;
    }

    public ApiOperationScenarioWSDTO getOperationScenario() {
        return operationScenario;
    }

    public void setOperationScenario(ApiOperationScenarioWSDTO operationScenario) {
        this.operationScenario = operationScenario;
    }

    public ApiOperationChannelWSDTO getOperationChannel() {
        return operationChannel;
    }

    public void setOperationChannel(ApiOperationChannelWSDTO operationChannel) {
        this.operationChannel = operationChannel;
    }
}
