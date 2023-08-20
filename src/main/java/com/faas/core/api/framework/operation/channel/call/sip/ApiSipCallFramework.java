package com.faas.core.api.framework.operation.channel.call.sip;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipCallWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SipCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiSipCallFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId,long sessionId,String campaignId,String processId) {

        return null;
    }


    public List<ApiSipCallWSDTO> apiGetSipCallsService(long agentId,long sessionId,String campaignId,String processId) {

        List<ApiSipCallWSDTO> sipCallWSDTOS = new ArrayList<>();
        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findBySessionIdAndCampaignIdAndProcessId(sessionId,campaignId,processId);
        for (SipCallDBModel sipCallDBModel : sipCallDBModels) {
            sipCallWSDTOS.add(new ApiSipCallWSDTO(sipCallDBModel));
        }
        return sipCallWSDTOS;
    }


    public ApiSipCallWSDTO apiGetSipCallService(long agentId,long sessionId,String campaignId,String processId,long callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(callId,sessionId,campaignId,processId);
        if (!sipCallDBModels.isEmpty()) {
            return new ApiSipCallWSDTO(sipCallDBModels.get(0));
        }
        return null;
    }



    public ApiSipCallWSDTO apiCreateSipCallService(long agentId,long sessionId,String campaignId,String processId,long numberId) {

        if (!sipCallRepository.existsBySessionIdAndCallState(sessionId, AppConstant.ACTIVE_CALL)) {

           // List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId, clientId);
            Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
            ApiSipAccountWSDTO sipAccountWSDTO = channelHelper.getApiSipAccountWSDTO(agentId, processId);

            if (clientPhoneDBModel.isPresent() && sipAccountWSDTO != null) {

                SipCallDBModel sipCallDBModel = new SipCallDBModel();

            //    sipCallDBModel.setSessionUUID(sessionDBModels.get(0).getSessionUUID());
        //        sipCallDBModel.setSessionId(sessionDBModels.get(0).getId());
         //       sipCallDBModel.setClientId(sessionDBModels.get(0).getClientId());
      //          sipCallDBModel.setAgentId(sessionDBModels.get(0).getAgentId());
       //         sipCallDBModel.setCampaignId(sessionDBModels.get(0).getCampaignId());
       //         sipCallDBModel.setProcessId(sessionDBModels.get(0).getProcessId());

                sipCallDBModel.setNumberId(clientPhoneDBModel.get().getId());
                sipCallDBModel.setPhoneNumber(clientPhoneDBModel.get().getPhoneNumber());
                sipCallDBModel.setAccountId(sipAccountWSDTO.getAccountId());
                sipCallDBModel.setCallerId(sipAccountWSDTO.getCallerId());
                sipCallDBModel.setProvider(sipAccountWSDTO.getProvider());
                sipCallDBModel.setConnectionId("");
                sipCallDBModel.setCallState(AppConstant.ACTIVE_CALL);
                sipCallDBModel.setsDate(appUtils.getCurrentTimeStamp());
                sipCallDBModel.setfDate(0);
                sipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
                sipCallDBModel.setcDate(appUtils.getCurrentTimeStamp());
                sipCallDBModel.setStatus(1);

                sipCallRepository.save(sipCallDBModel);

                return null;
            }
        }
        return null;
    }



    public ApiSipCallWSDTO apiUpdateSipCallService(long agentId,long sessionId,String campaignId,String processId,long callId,String callState) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionId(callId, sessionId);
        if (sipCallDBModels.size() > 0) {
            sipCallDBModels.get(0).setCallState(callState);
            if (callState.equalsIgnoreCase(AppConstant.FINISHED_CALL)) {
                sipCallDBModels.get(0).setfDate(appUtils.getCurrentTimeStamp());
            }
            sipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            sipCallRepository.save(sipCallDBModels.get(0));

            return null;
        }
        return null;
    }


    public ApiSipCallWSDTO apiRemoveSipCallService(long agentId,long sessionId,String campaignId,String processId,long callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionId(callId, sessionId);
        if (sipCallDBModels.size() > 0) {
            sipCallRepository.delete(sipCallDBModels.get(0));
            return null;
        }
        return null;
    }



}
