package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipCallRepository extends MongoRepository<SipCallDBModel, String> {

    boolean existsByIdAndCallState(String callId,String callState);
    boolean existsBySessionIdAndCallState(long sessionId,String callState);
    List<SipCallDBModel>findBySessionId(long sessionId);
    List<SipCallDBModel>findByIdAndSessionId(String callId, long sessionId);
    List<SipCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<SipCallDBModel>findByClientId(long clientId);
    List<SipCallDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
}
