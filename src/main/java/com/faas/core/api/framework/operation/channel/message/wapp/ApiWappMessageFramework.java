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


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessagesService(long agentId, long sessionId) {

        List<SessionDBModel>sessionDBModels =  sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            return operationMapper.mapApiOperationWappMessageWSDTO(sessionDBModels.get(0),clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
        }
        return null;
    }


    public List<ApiWappMessageWSDTO> apiGetWappMessagesService(long agentId,long sessionId,String campaignId, String processId){

        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();
        List<WappMessageDBModel>wappMessageDBModels = wappMessageRepository.findBySessionIdAndCampaignIdAndProcessId(sessionId,campaignId,processId);
        for (WappMessageDBModel wappMessageDBModel : wappMessageDBModels) {
            wappMessageWSDTOS.add(new ApiWappMessageWSDTO(wappMessageDBModel));
        }
        return wappMessageWSDTOS;
    }


    public ApiWappMessageWSDTO apiGetWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!wappMessageDBModels.isEmpty()){
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageWSDTO apiSendWappMessageService() {

        return null;
    }



    public ApiWappMessageWSDTO apiUpdateWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId){

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!wappMessageDBModels.isEmpty()){
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageWSDTO apiRemoveWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId){

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!wappMessageDBModels.isEmpty()){
            wappMessageRepository.delete(wappMessageDBModels.get(0));
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }




    public ApiWappMessageTempWSDTO apiGetWappMessageTempsService(long agentId,long sessionId,String campaignId,String processId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            ApiWappMessageTempWSDTO wappMessageTempWSDTO = new ApiWappMessageTempWSDTO();
            ApiWappAccountWSDTO wappAccountWSDTO = operationMapper.getApiWappAccountWSDTO(agentId,processId);
            if (wappAccountWSDTO != null){
                wappMessageTempWSDTO.setWappAccount(wappAccountWSDTO);
            }
            wappMessageTempWSDTO.setPhones(clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
            wappMessageTempWSDTO.setWappTemps(wappMessageTempRepository.findByProcessId(processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }

    public ApiWappMessageTempWSDTO apiGetWappMessageTempService(long agentId,long sessionId,String campaignId,String processId,String tempId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            ApiWappMessageTempWSDTO wappMessageTempWSDTO = new ApiWappMessageTempWSDTO();
            ApiWappAccountWSDTO wappAccountWSDTO = operationMapper.getApiWappAccountWSDTO(agentId,processId);
            if (wappAccountWSDTO != null){
                wappMessageTempWSDTO.setWappAccount(wappAccountWSDTO);
            }
            wappMessageTempWSDTO.setPhones(clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
            wappMessageTempWSDTO.setWappTemps(wappMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }



}
