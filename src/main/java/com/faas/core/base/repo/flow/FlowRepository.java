package com.faas.core.base.repo.flow;

import com.faas.core.base.model.db.flow.FlowDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowRepository extends PagingAndSortingRepository<FlowDBModel, Long> {

    List<FlowDBModel> findByStatus(int status);

}
