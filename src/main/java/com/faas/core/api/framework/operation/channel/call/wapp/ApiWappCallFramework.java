package com.faas.core.api.framework.operation.channel.call.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.WappCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiWappCallFramework {

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappCallWSDTO apiGetOperationWappCallService(long agentId, long sessionId, long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientId);
        if (sessionDBModels.size()>0){
            return operationMapper.mapApiOperationWappCallWSDTO(sessionDBModels.get(0),clientPhoneDBModels);
        }
        return null;
    }


    public ApiOperationWappCallWSDTO apiGetWappCallService(long agentId,long sessionId,long clientId ,String callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
        operationWappCallWSDTO.setPhones(clientPhoneRepository.findByClientId(clientId));
        List<WappCallDBModel> wappCallDBModels = wappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (wappCallDBModels.size()>0){
            operationWappCallWSDTO.setWappCall(wappCallDBModels.get(0));
        }
        return operationWappCallWSDTO;
    }


    public ApiOperationWappCallWSDTO apiCreateWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;
    }


    public ApiOperationWappCallWSDTO apiUpdateWappCallService(long agentId,long sessionId,long clientId,String callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
        operationWappCallWSDTO.setPhones(clientPhoneRepository.findByClientId(clientId));
        List<WappCallDBModel> wappCallDBModels = wappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (wappCallDBModels.size()>0){
            operationWappCallWSDTO.setWappCall(wappCallDBModels.get(0));
        }
        return operationWappCallWSDTO;
    }


    public ApiOperationWappCallWSDTO apiRemoveWappCallService(long agentId,long sessionId,long clientId, String callId) {

        List<WappCallDBModel> wappCallDBModels = wappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (wappCallDBModels.size()>0){

            wappCallRepository.delete(wappCallDBModels.get(0));
            ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
            operationWappCallWSDTO.setPhones(clientPhoneRepository.findByClientId(clientId));
            operationWappCallWSDTO.setWappCall(wappCallDBModels.get(0));

            return operationWappCallWSDTO;
        }
        return null;
    }



}
