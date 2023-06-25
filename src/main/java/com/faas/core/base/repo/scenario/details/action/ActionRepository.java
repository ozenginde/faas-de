package com.faas.core.base.repo.scenario.details.action;

import com.faas.core.base.model.db.scenario.details.action.ActionDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends MongoRepository<ActionDBModel, String> {

    List<ActionDBModel> findByStatus(int status);
    List<ActionDBModel>findByScenarioId(String scenarioId);

}
