package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiMessengerAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.push.dto.ApiPushAccountWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSipChannelRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSmsChannelRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessWappChannelRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OperationHelper {


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    AppUtils appUtils;




    public ApiSipAccountWSDTO createApiSipCallAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiSipAccountWSDTO sipCallAccountWSDTO = new ApiSipAccountWSDTO();


        return null;
    }


    public ApiWappAccountWSDTO createApiWappCallAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiWappAccountWSDTO wappCallAccountWSDTO = new ApiWappAccountWSDTO();
        List<ProcessWappChannelDBModel> processWappChannels = processWappChannelRepository.findByProcessId(processId);
        if (processWappChannels.size()>0){
            wappCallAccountWSDTO.setCallStatus(processWappChannels.get(0).getCallStatus());
        }
        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (userDetails.size()>0 && userDetails.get(0).getWappChannel() != null){
            wappCallAccountWSDTO.setAccountId(userDetails.get(0).getWappChannel().getAccountId());
            wappCallAccountWSDTO.setInstanceKey(userDetails.get(0).getWappChannel().getInstanceKey());
            wappCallAccountWSDTO.setPhoneNumber(userDetails.get(0).getWappChannel().getPhoneNumber());
            wappCallAccountWSDTO.setServerUrl(userDetails.get(0).getWappChannel().getServerUrl());

            if (userDetails.get(0).getWappChannel().getAccountDatas() != null){
                wappCallAccountWSDTO.setAccountDatas(userDetails.get(0).getWappChannel().getAccountDatas());
            }else {
                wappCallAccountWSDTO.setAccountDatas(new ArrayList<>());
            }
            wappCallAccountWSDTO.setcDate(userDetails.get(0).getWappChannel().getcDate());
            wappCallAccountWSDTO.setStatus(userDetails.get(0).getWappChannel().getStatus());
        }
        return wappCallAccountWSDTO;
    }


    public ApiEmailAccountWSDTO createApiEmailAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){


        return null;
    }


    public ApiSmsAccountWSDTO createApiSmsMessageAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiSmsAccountWSDTO smsMessageAccountWSDTO = new ApiSmsAccountWSDTO();
        List<ProcessSmsChannelDBModel> processSmsChannels = processSmsChannelRepository.findByProcessId(processId);
        if (processSmsChannels.size()>0){

        }
        return null;
    }


    public ApiWappAccountWSDTO createApiWappMessageAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiWappAccountWSDTO wappAccountWSDTO = new ApiWappAccountWSDTO();
        List<ProcessWappChannelDBModel> processWappChannels = processWappChannelRepository.findByProcessId(processId);
        if (processWappChannels.size()>0){
        }
        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (userDetails.size()>0 && userDetails.get(0).getWappChannel() != null){
            wappAccountWSDTO.setAccountId(userDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setInstanceKey(userDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(userDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(userDetails.get(0).getWappChannel().getServerUrl());

            if (userDetails.get(0).getWappChannel().getAccountDatas() != null){
                wappAccountWSDTO.setAccountDatas(userDetails.get(0).getWappChannel().getAccountDatas());
            }else {
                wappAccountWSDTO.setAccountDatas(new ArrayList<>());
            }
            wappAccountWSDTO.setcDate(userDetails.get(0).getWappChannel().getcDate());
            wappAccountWSDTO.setStatus(userDetails.get(0).getWappChannel().getStatus());
        }
        return wappAccountWSDTO;
    }


    public ApiMessengerAccountWSDTO createApiMessengerAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        return null;
    }


    public ApiPushAccountWSDTO createApiPushAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        return null;
    }


}
