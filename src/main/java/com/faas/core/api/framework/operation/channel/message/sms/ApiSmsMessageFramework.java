package com.faas.core.api.framework.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.process.details.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiSmsMessageFramework {

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsMessageWSDTO apiGetOperationSmsMessageService(long agentId, long sessionId, long clientId) {

        List<SessionDBModel>sessionDBModels =  sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientId);
        if (sessionDBModels.size()>0){
            return operationMapper.mapApiOperationSmsMessageWSDTO(sessionDBModels.get(0),clientPhoneDBModels);
        }
        return null;
    }


    public List<ApiSmsMessageWSDTO> apiGetSmsMessagesService(long agentId,long sessionId,long clientId,String processId) {

        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = new ArrayList<>();
        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findBySessionIdAndClientIdAndProcessId(sessionId,clientId,processId);
        for (SmsMessageDBModel smsMessageDBModel : smsMessageDBModels) {
            smsMessageWSDTOS.add(new ApiSmsMessageWSDTO(smsMessageDBModel));
        }
        return smsMessageWSDTOS;
    }

    public ApiSmsMessageWSDTO apiGetSmsMessageService(long agentId,long sessionId,long clientId,String processId, String messageId) {

        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findByIdAndSessionIdAndClientIdAndProcessId(messageId,sessionId,clientId,processId);
        if (smsMessageDBModels.size()>0) {
            return new ApiSmsMessageWSDTO(smsMessageDBModels.get(0));
        }
        return null;
    }



    public ApiSmsMessageWSDTO apiSendSmsMessageService(){

        return null;
    }



    public ApiSmsMessageWSDTO apiUpdateSmsMessageService(long agentId,long sessionId,long clientId,String processId,String messageId) {

        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findByIdAndSessionIdAndClientIdAndProcessId(messageId,sessionId,clientId,processId);
        if (smsMessageDBModels.size()>0) {
            return new ApiSmsMessageWSDTO(smsMessageDBModels.get(0));
        }
        return null;
    }

    public ApiSmsMessageWSDTO apiRemoveSmsMessageService(long agentId,long sessionId,long clientId,String processId,String messageId) {

        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findByIdAndSessionIdAndClientIdAndProcessId(messageId,sessionId,clientId,processId);
        if (smsMessageDBModels.size()>0) {
            smsMessageRepository.delete(smsMessageDBModels.get(0));
            return new ApiSmsMessageWSDTO(smsMessageDBModels.get(0));
        }
        return null;
    }




    public ApiSmsMessageTempWSDTO apiGetSmsMessageTempsService(long agentId,long sessionId,long clientId, String processId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhones =  clientPhoneRepository.findByClientId(clientId);
        ApiSmsAccountWSDTO smsAccountWSDTO = operationMapper.getApiSmsAccountWSDTO(processId);
        if (sessionDBModels.size()>0 && smsAccountWSDTO != null){

            ApiSmsMessageTempWSDTO smsMessageTempWSDTO = new ApiSmsMessageTempWSDTO();
            smsMessageTempWSDTO.setSmsAccount(smsAccountWSDTO);
            smsMessageTempWSDTO.setPhones(clientPhones);
            smsMessageTempWSDTO.setSmsTemps(smsMessageTempRepository.findByProcessId(processId));

            return smsMessageTempWSDTO;
        }
        return null;
    }


    public ApiSmsMessageTempWSDTO apiGetSmsMessageTempService(long agentId,long sessionId,long clientId,String processId,String tempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhones =  clientPhoneRepository.findByClientId(clientId);
        ApiSmsAccountWSDTO smsAccountWSDTO = operationMapper.getApiSmsAccountWSDTO(processId);
        if (sessionDBModels.size()>0 && smsAccountWSDTO != null){

            ApiSmsMessageTempWSDTO smsMessageTempWSDTO = new ApiSmsMessageTempWSDTO();
            smsMessageTempWSDTO.setSmsAccount(smsAccountWSDTO);
            smsMessageTempWSDTO.setPhones(clientPhones);
            smsMessageTempWSDTO.setSmsTemps(smsMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return smsMessageTempWSDTO;
        }
        return null;
    }


}
