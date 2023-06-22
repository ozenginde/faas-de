package com.faas.core.base.repo.operation.scenario;

import com.faas.core.base.model.db.operation.scenario.ScenarioExecuteDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioExecuteRepository extends MongoRepository<ScenarioExecuteDBModel, String> {

    List<ScenarioExecuteDBModel>findByCampaignId(String campaignId);
    List<ScenarioExecuteDBModel>findByProcessId(String processId);
    List<ScenarioExecuteDBModel>findByScenarioId(String scenarioId);
    List<ScenarioExecuteDBModel>findBySessionIdAndProcessId(long sessionId,String processId);
    List<ScenarioExecuteDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId,long clientId,String processId);


}
