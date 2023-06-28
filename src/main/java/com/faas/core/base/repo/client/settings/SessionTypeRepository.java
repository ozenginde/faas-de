package com.faas.core.base.repo.client.settings;

import com.faas.core.base.model.db.client.settings.SessionTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionTypeRepository extends PagingAndSortingRepository<SessionTypeDBModel, Long> {

    List<SessionTypeDBModel> findByStatus(int status);

}
