package com.faas.core.base.repo.operation.scenario;

import com.faas.core.base.model.db.operation.details.ScenarioExecuteDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioExecuteRepository extends MongoRepository<ScenarioExecuteDBModel, String> {

    List<ScenarioExecuteDBModel>findByScenarioId(String scenarioId);

}
