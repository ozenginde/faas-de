package com.faas.core.base.repo.process.details.temp;

import com.faas.core.base.model.db.process.details.temp.WappMessageTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageTempRepository extends MongoRepository<WappMessageTempDBModel, String> {

    List<WappMessageTempDBModel> findByStatus(int status);

    List<WappMessageTempDBModel> findByProcessId(String processId);

    List<WappMessageTempDBModel>findByIdAndProcessId(String tempId,String processId);
}
