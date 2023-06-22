package com.faas.core.base.repo.client.settings;

import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientTypeRepository extends PagingAndSortingRepository<ClientTypeDBModel, Long> {

    List<ClientTypeDBModel> findByStatus(int status);
    List<ClientTypeDBModel>findByClientType(String clientType);

}
