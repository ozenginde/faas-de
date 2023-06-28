package com.faas.core.base.repo.flow.settings;

import com.faas.core.base.model.db.flow.settings.FlowTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowTypeRepository extends PagingAndSortingRepository<FlowTypeDBModel, Long> {

    List<FlowTypeDBModel> findByStatus(int status);

}
