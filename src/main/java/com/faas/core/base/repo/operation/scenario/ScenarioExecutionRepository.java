package com.faas.core.base.repo.operation.scenario;

import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioExecutionRepository extends MongoRepository<ScenarioExecutionDBModel, String> {

    List<ScenarioExecutionDBModel>findByCampaignId(String campaignId);
    List<ScenarioExecutionDBModel>findByProcessId(String processId);
    List<ScenarioExecutionDBModel>findByScenarioId(String scenarioId);
    List<ScenarioExecutionDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
    List<ScenarioExecutionDBModel>findByIdAndSessionIdAndClientId(String executionId,long sessionId,long clientId);
    List<ScenarioExecutionDBModel>findBySessionIdAndProcessId(long sessionId, String processId);
    List<ScenarioExecutionDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId, long clientId, String processId);


}