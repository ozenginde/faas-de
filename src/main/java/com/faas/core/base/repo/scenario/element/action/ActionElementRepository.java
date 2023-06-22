package com.faas.core.base.repo.scenario.element.action;

import com.faas.core.base.model.db.scenario.element.action.ActionElementDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionElementRepository extends MongoRepository<ActionElementDBModel, String> {

    List<ActionElementDBModel> findByStatus(int status);
    List<ActionElementDBModel>findByScenarioId(String scenarioId);

}
