package com.faas.core.api.framework.operation.channel.call.sip;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SipCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiSipCallFramework {

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSipCallWSDTO fillApiOperationSipCallWSDTO(long agentId,long sessionId,long clientId,String processId){

        ApiOperationSipCallWSDTO operationSipCallWSDTO = new ApiOperationSipCallWSDTO();
        operationSipCallWSDTO.setSipAccount(operationMapper.getApiSipAccountWSDTO(agentId, processId));
        operationSipCallWSDTO.setPhones(clientPhoneRepository.findByClientId(clientId));
        List<SipCallDBModel> sipCalls = sipCallRepository.findBySessionIdAndCallState(sessionId, AppConstant.ACTIVE_CALL);
        if (sipCalls.size() > 0) {
            operationSipCallWSDTO.setSipCall(sipCalls.get(0));
        }
        operationSipCallWSDTO.setSipCalls(sipCallRepository.findBySessionId(sessionId));

        return operationSipCallWSDTO;
    }


    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId, long sessionId,long clientId,String processId) {

        return fillApiOperationSipCallWSDTO(agentId,sessionId,clientId,processId);
    }


    public ApiOperationSipCallWSDTO apiGetSipCallService(long agentId, long sessionId, long clientId, String processId, String callId) {

        ApiOperationSipCallWSDTO operationSipCallWSDTO = new ApiOperationSipCallWSDTO();
        operationSipCallWSDTO.setSipAccount(operationMapper.getApiSipAccountWSDTO(agentId, processId));
        operationSipCallWSDTO.setPhones(clientPhoneRepository.findByClientId(clientId));
        List<SipCallDBModel> sipCalls = sipCallRepository.findByIdAndSessionId(callId, sessionId);
        if (sipCalls.size() > 0) {
            operationSipCallWSDTO.setSipCall(sipCalls.get(0));
        }
        return operationSipCallWSDTO;
    }


    public ApiOperationSipCallWSDTO apiCreateSipCallService(long agentId, long sessionId, long clientId, String processId, long numberId) {

        if (!sipCallRepository.existsBySessionIdAndCallState(sessionId, AppConstant.ACTIVE_CALL)) {

            List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId, clientId);
            Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
            ApiSipAccountWSDTO sipAccountWSDTO = operationMapper.getApiSipAccountWSDTO(agentId, processId);
            if (sessionDBModels.size() > 0 && clientPhoneDBModel.isPresent() && sipAccountWSDTO != null) {

                SipCallDBModel sipCallDBModel = new SipCallDBModel();

                sipCallDBModel.setSessionUUID(sessionDBModels.get(0).getSessionUUID());
                sipCallDBModel.setSessionId(sessionDBModels.get(0).getId());
                sipCallDBModel.setClientId(sessionDBModels.get(0).getClientId());
                sipCallDBModel.setAgentId(sessionDBModels.get(0).getAgentId());
                sipCallDBModel.setCampaignId(sessionDBModels.get(0).getCampaignId());
                sipCallDBModel.setProcessId(sessionDBModels.get(0).getProcessId());
                sipCallDBModel.setNumberId(clientPhoneDBModel.get().getId());
                sipCallDBModel.setPhoneNumber(clientPhoneDBModel.get().getPhoneNumber());
                sipCallDBModel.setSipAccountId(sipAccountWSDTO.getAccountId());
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

                return fillApiOperationSipCallWSDTO(agentId,sessionId,clientId,processId);
            }
        }
        return null;
    }


    public ApiOperationSipCallWSDTO apiUpdateSipCallService(long agentId, long sessionId, long clientId, String processId, String callId, String callState) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionId(callId, sessionId);
        if (sipCallDBModels.size() > 0) {
            sipCallDBModels.get(0).setCallState(callState);
            if (callState.equalsIgnoreCase(AppConstant.FINISHED_CALL)) {
                sipCallDBModels.get(0).setfDate(appUtils.getCurrentTimeStamp());
            }
            sipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            sipCallRepository.save(sipCallDBModels.get(0));

            return fillApiOperationSipCallWSDTO(agentId,sessionId,clientId,processId);
        }
        return null;
    }


    public ApiOperationSipCallWSDTO apiRemoveSipCallService(long agentId, long sessionId, long clientId, String processId, String callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionId(callId, sessionId);
        if (sipCallDBModels.size() > 0) {
            sipCallRepository.delete(sipCallDBModels.get(0));
            return fillApiOperationSipCallWSDTO(agentId,sessionId,clientId,processId);
        }
        return null;
    }


}
