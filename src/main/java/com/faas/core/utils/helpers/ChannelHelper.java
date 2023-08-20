package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.base.model.db.operation.channel.dao.SmsMessageDAO;
import com.faas.core.base.model.db.operation.channel.dao.WappMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSipChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.dao.EmailAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.PushAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.SmsAccountDAO;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SipCallRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSipChannelRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChannelHelper {


    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public SmsMessageDAO getSmsMessageDAO(SessionDBModel sessionDBModel, SmsMessageTempDBModel smsMessageTempDBModel, ProcessSmsChannelDBModel processSmsChannelDBModel){

        SmsMessageDAO smsMessageDAO = new SmsMessageDAO();

        smsMessageDAO.setTempId(smsMessageTempDBModel.getId());
        smsMessageDAO.setSmsTitle(smsMessageTempDBModel.getSmsTitle());
        smsMessageDAO.setSmsBody(smsMessageTempDBModel.getSmsBody());
        smsMessageDAO.setSenderId(smsMessageTempDBModel.getSenderId());
        smsMessageDAO.setMessageType(smsMessageTempDBModel.getMessageType());
        smsMessageDAO.setAccountId(processSmsChannelDBModel.getAccountId());
        smsMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return smsMessageDAO;
    }


    public WappMessageDAO getWappMessageDAO(SessionDBModel sessionDBModel, WappMessageTempDBModel wappMessageTempDBModel, UserDetailsDBModel agentDetails){

        WappMessageDAO wappMessageDAO = new WappMessageDAO();

        wappMessageDAO.setTempId(wappMessageTempDBModel.getId());
        wappMessageDAO.setWappTitle(wappMessageTempDBModel.getWappTitle());
        wappMessageDAO.setWappBody(wappMessageTempDBModel.getWappBody());
        wappMessageDAO.setMessageDatas(new ArrayList<>());
        wappMessageDAO.setMessageType(wappMessageTempDBModel.getMessageType());
        wappMessageDAO.setAccountId(agentDetails.getWappChannel().getAccountId());
        wappMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return wappMessageDAO;
    }


    public ApiOperationSipCallWSDTO getApiOperationSipCallWSDTO(long agentId, long sessionId, long clientId, String processId){

        ApiOperationSipCallWSDTO operationSipCallWSDTO = new ApiOperationSipCallWSDTO();

        operationSipCallWSDTO.setSipAccount(getApiSipAccountWSDTO(agentId, processId));
        operationSipCallWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
        List<SipCallDBModel> sipCalls = sipCallRepository.findBySessionIdAndCallState(sessionId, AppConstant.ACTIVE_CALL);
        if (!sipCalls.isEmpty()) {
            operationSipCallWSDTO.setCurrentSipCall(sipCalls.get(0));
        }
        return operationSipCallWSDTO;
    }


    public ApiSipAccountWSDTO getApiSipAccountWSDTO(long agentId, String processId) {

        List<ProcessSipChannelDBModel> sipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);

        if (!sipChannelDBModels.isEmpty() && !agentDetails.isEmpty() && agentDetails.get(0).getSipChannel() != null) {

            ApiSipAccountWSDTO sipAccountWSDTO = new ApiSipAccountWSDTO();

            sipAccountWSDTO.setAccountId(agentDetails.get(0).getSipChannel().getAccountId());
            sipAccountWSDTO.setAccount(agentDetails.get(0).getSipChannel().getAccount());
            sipAccountWSDTO.setUserName(agentDetails.get(0).getSipChannel().getUserName());
            sipAccountWSDTO.setAuthUser(agentDetails.get(0).getSipChannel().getAuthUser());
            sipAccountWSDTO.setPassword(agentDetails.get(0).getSipChannel().getPassword());
            sipAccountWSDTO.setSipUrl(agentDetails.get(0).getSipChannel().getSipUrl());
            sipAccountWSDTO.setAccountDatas(agentDetails.get(0).getSipChannel().getAccountDatas());
            sipAccountWSDTO.setProvider(agentDetails.get(0).getSipChannel().getProvider());
            sipAccountWSDTO.setCallerId(sipChannelDBModels.get(0).getCallerId());
            sipAccountWSDTO.setSipStatus(sipChannelDBModels.get(0).getSipStatus());
            sipAccountWSDTO.setcDate(sipChannelDBModels.get(0).getcDate());
            sipAccountWSDTO.setStatus(sipChannelDBModels.get(0).getStatus());

            return sipAccountWSDTO;
        }
        return null;
    }


    public ApiOperationSipCallWSDTO mapApiOperationSipCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiSipAccountWSDTO sipAccountWSDTO = getApiSipAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (sipAccountWSDTO != null) {
            ApiOperationSipCallWSDTO operationSipCall = new ApiOperationSipCallWSDTO();
            operationSipCall.setSipAccount(sipAccountWSDTO);
            operationSipCall.setClientPhones(clientPhones);
            List<SipCallDBModel> activeSipCall = sipCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.ACTIVE_CALL);
            if (!activeSipCall.isEmpty()) {
                operationSipCall.setCurrentSipCall(activeSipCall.get(0));
            }
            return operationSipCall;
        }
        return null;
    }



    public SmsAccountDAO mapProcessSmsAccountDAO(SmsAccountDBModel smsAccountDBModel) {

        SmsAccountDAO smsAccountDAO = new SmsAccountDAO();
        smsAccountDAO.setAccountId(smsAccountDBModel.getId());
        smsAccountDAO.setAccount(smsAccountDBModel.getAccount());
        smsAccountDAO.setUserName(smsAccountDBModel.getUserName());
        smsAccountDAO.setPassword(smsAccountDBModel.getPassword());
        smsAccountDAO.setApiToken(smsAccountDBModel.getApiToken());
        smsAccountDAO.setApiUrl(smsAccountDBModel.getApiUrl());
        if (smsAccountDBModel.getAccountDatas() !=null){
            smsAccountDAO.setAccountDatas(smsAccountDBModel.getAccountDatas());
        }else{
            smsAccountDAO.setAccountDatas(new ArrayList<>());
        }
        smsAccountDAO.setProvider(smsAccountDBModel.getProvider());
        smsAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        smsAccountDAO.setStatus(1);

        return smsAccountDAO;
    }


    public EmailAccountDAO mapProcessEmailAccountDAO(EmailAccountDBModel emailAccountDBModel) {

        EmailAccountDAO emailAccountDAO = new EmailAccountDAO();
        emailAccountDAO.setAccountId(emailAccountDBModel.getId());
        emailAccountDAO.setAccount(emailAccountDBModel.getAccount());
        if (emailAccountDBModel.getAccountDatas() != null){
            emailAccountDAO.setAccountDatas(emailAccountDBModel.getAccountDatas());
        }else {
            emailAccountDAO.setAccountDatas(new ArrayList<>());
        }
        emailAccountDAO.setProvider(emailAccountDBModel.getProvider());
        emailAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        emailAccountDAO.setStatus(1);

        return emailAccountDAO;
    }


    public PushAccountDAO mapProcessPushAccountDAO(PushAccountDBModel pushAccountDBModel) {

        PushAccountDAO pushAccountDAO = new PushAccountDAO();
        pushAccountDAO.setAccountId(pushAccountDBModel.getId());
        pushAccountDAO.setAccount(pushAccountDBModel.getAccount());
        if (pushAccountDBModel.getAccountDatas() != null){
            pushAccountDAO.setAccountDatas(pushAccountDBModel.getAccountDatas());
        }else {
            pushAccountDAO.setAccountDatas(new ArrayList<>());
        }
        pushAccountDAO.setProvider(pushAccountDBModel.getProvider());
        pushAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        pushAccountDAO.setStatus(1);

        return pushAccountDAO;
    }


}
