package com.faas.core.api.framework.operation.channel.message.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiWappMessageFramework {

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessagesService(long agentId, long sessionId, long clientId) {

        List<SessionDBModel>sessionDBModels =  sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientId);
        if (sessionDBModels.size()>0){
            return operationMapper.mapApiOperationWappMessageWSDTO(sessionDBModels.get(0),clientPhoneDBModels);
        }
        return null;
    }


    public List<ApiWappMessageWSDTO> apiGetWappMessagesService(long agentId,long sessionId,long clientId, String processId){

        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();
        List<WappMessageDBModel>wappMessageDBModels = wappMessageRepository.findBySessionIdAndClientIdAndProcessId(sessionId,clientId,processId);
        for (WappMessageDBModel wappMessageDBModel : wappMessageDBModels) {
            wappMessageWSDTOS.add(new ApiWappMessageWSDTO(wappMessageDBModel));
        }
        return wappMessageWSDTOS;
    }

    public ApiWappMessageWSDTO apiGetWappMessageService(long agentId,long sessionId, long clientId,String processId,String messageId) {

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndClientIdAndProcessId(messageId,sessionId,clientId,processId);
        if (wappMessageDBModels.size()>0){
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }

    public ApiWappMessageWSDTO apiSendWappMessageService() {

        return null;
    }

    public ApiWappMessageWSDTO apiUpdateWappMessageService(long agentId,long sessionId,long clientId,String processId,String messageId){

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndClientIdAndProcessId(messageId,sessionId,clientId,processId);
        if (wappMessageDBModels.size()>0){
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }

    public ApiWappMessageWSDTO apiRemoveWappMessageService(long agentId,long sessionId,long clientId,String processId,String messageId){

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndClientIdAndProcessId(messageId,sessionId,clientId,processId);
        if (wappMessageDBModels.size()>0){
            wappMessageRepository.delete(wappMessageDBModels.get(0));
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }




    public ApiWappMessageTempWSDTO apiGetWappMessageTempsService(long agentId, long sessionId, long clientId, String processId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhones =  clientPhoneRepository.findByClientId(clientId);
        ApiWappAccountWSDTO wappAccountWSDTO = operationMapper.getApiWappAccountWSDTO(agentId,processId);
        if (sessionDBModels.size()>0 && wappAccountWSDTO != null){

            ApiWappMessageTempWSDTO wappMessageTempWSDTO = new ApiWappMessageTempWSDTO();
            wappMessageTempWSDTO.setWappAccount(wappAccountWSDTO);
            wappMessageTempWSDTO.setPhones(clientPhones);
            wappMessageTempWSDTO.setWappTemps(wappMessageTempRepository.findByProcessId(processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }

    public ApiWappMessageTempWSDTO apiGetWappMessageTempService(long agentId,long sessionId,long clientId,String processId,String tempId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhones =  clientPhoneRepository.findByClientId(clientId);
        ApiWappAccountWSDTO wappAccountWSDTO = operationMapper.getApiWappAccountWSDTO(agentId,processId);
        if (sessionDBModels.size()>0 && wappAccountWSDTO != null){

            ApiWappMessageTempWSDTO wappMessageTempWSDTO = new ApiWappMessageTempWSDTO();
            wappMessageTempWSDTO.setWappAccount(wappAccountWSDTO);
            wappMessageTempWSDTO.setPhones(clientPhones);
            wappMessageTempWSDTO.setWappTemps(wappMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }



}
