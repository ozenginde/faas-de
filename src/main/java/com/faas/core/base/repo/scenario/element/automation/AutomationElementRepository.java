package com.faas.core.base.repo.scenario.element.automation;

import com.faas.core.base.model.db.scenario.element.automation.AutomationElementDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationElementRepository extends MongoRepository<AutomationElementDBModel, String> {

    List<AutomationElementDBModel> findByStatus(int status);
    List<AutomationElementDBModel>findByScenarioId(String scenarioId);

}
