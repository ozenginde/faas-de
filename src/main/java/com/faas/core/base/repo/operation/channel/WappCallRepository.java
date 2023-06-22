package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.WappCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallRepository extends MongoRepository<WappCallDBModel, String> {

    List<WappCallDBModel>findBySessionId(long sessionId);
    List<WappCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<WappCallDBModel>findByIdAndSessionId(String callId, long sessionId);
    List<WappCallDBModel>findByClientId(long clientId);
    List<WappCallDBModel>findBySessionIdAndClientId(long sessioId,long clientId);
}
