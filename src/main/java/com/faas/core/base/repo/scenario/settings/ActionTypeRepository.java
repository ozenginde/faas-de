package com.faas.core.base.repo.scenario.settings;

import com.faas.core.base.model.db.scenario.settings.ActionTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionTypeRepository extends PagingAndSortingRepository<ActionTypeDBModel, Long> {

    List<ActionTypeDBModel> findByStatus(int status);


}
