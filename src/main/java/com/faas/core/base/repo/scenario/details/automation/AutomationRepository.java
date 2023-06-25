package com.faas.core.base.repo.scenario.details.automation;

import com.faas.core.base.model.db.scenario.details.automation.AutomationDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationRepository extends MongoRepository<AutomationDBModel, String> {

    List<AutomationDBModel> findByStatus(int status);
    List<AutomationDBModel>findByScenarioId(String scenarioId);

}
