package com.faas.core.utils.mapper;


import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiOperationMessengerWSDTO;
import com.faas.core.api.model.ws.operation.channel.push.dto.ApiOperationPushMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.push.dto.ApiPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.osint.dto.ApiOperationOsIntWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.content.dto.ApiScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.execution.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.ScenarioExecutionDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.automation.content.AutomationTempRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecuteRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class OperationMapper {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    PushMessageRepository pushMessageRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioExecuteRepository scenarioExecuteRepository;

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    AppUtils appUtils;



    public OperationDBModel mapOperationDBModel(SessionDBModel sessionDBModel) {

        if (!operationRepository.existsBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId())){

            OperationDBModel operationDBModel = new OperationDBModel();
            operationDBModel.setSessionId(sessionDBModel.getId());
            operationDBModel.setSessionUUID(sessionDBModel.getSessionUUID());
            operationDBModel.setClientId(sessionDBModel.getClientId());
            operationDBModel.setAgentId(sessionDBModel.getAgentId());
            operationDBModel.setCampaignId(sessionDBModel.getCampaignId());
            operationDBModel.setProcessId(sessionDBModel.getProcessId());
            operationDBModel.setActivities(new ArrayList<>());
            operationDBModel.setOperationState(AppConstant.READY_OPERATION);
            operationDBModel.setOperationResult(AppConstant.RESULT_NONE);
            operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setStatus(1);

            return operationDBModel;
        }
        return null;
    }


    public ApiOperationDetailsWSDTO mapApiOperationDetailsWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel, OperationDBModel operationDBModel, CampaignDBModel campaignDBModel, ProcessDBModel processDBModel) {

        ApiOperationDetailsWSDTO operationDetailsWSDTO = new ApiOperationDetailsWSDTO();

        operationDetailsWSDTO.setOperation(operationDBModel);
        operationDetailsWSDTO.setOperationSession(sessionDBModel);
        operationDetailsWSDTO.setOperationClient(mapApiOperationClientWSDTO(clientDBModel));
        operationDetailsWSDTO.setOperationOsInt(mapApiOperationOsIntWSDTO(clientDBModel));
        operationDetailsWSDTO.setOperationNote(mapApiOperationNoteWSDTO(clientDBModel));
        operationDetailsWSDTO.setOperationCampaign(mapApiOperationCampaignWSDTO(campaignDBModel, processDBModel));
        operationDetailsWSDTO.setOperationActivities(mapApiOperationActivities(operationDBModel));
        operationDetailsWSDTO.setOperationScenario(mapApiOperationScenarioWSDTO(sessionDBModel.getId(), sessionDBModel.getClientId(),sessionDBModel.getProcessId()));
        operationDetailsWSDTO.setOperationChannel(mapApiOperationChannelWSDTO(sessionDBModel,clientDBModel));

        return operationDetailsWSDTO;
    }



    public ApiOperationClientWSDTO mapApiOperationClientWSDTO(ClientDBModel clientDBModel) {

        ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();

        operationClientWSDTO.setClient(clientDBModel);
        operationClientWSDTO.setClientDatas(clientDataRepository.findByClientId(clientDBModel.getId()));
        operationClientWSDTO.setClientAddresses(clientAddressRepository.findByClientId(clientDBModel.getId()));
        operationClientWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientDBModel.getId()));
        operationClientWSDTO.setClientEmails(clientEmailRepository.findByClientId(clientDBModel.getId()));

        return operationClientWSDTO;
    }


    public ApiOperationOsIntWSDTO mapApiOperationOsIntWSDTO(ClientDBModel clientDBModel) {

        ApiOperationOsIntWSDTO operationOSIntWSDTO = new ApiOperationOsIntWSDTO();
        operationOSIntWSDTO.setClient(clientDBModel);
        return operationOSIntWSDTO;
    }

    public ApiOperationNoteWSDTO mapApiOperationNoteWSDTO(ClientDBModel clientDBModel) {

        ApiOperationNoteWSDTO operationNoteWSDTO = new ApiOperationNoteWSDTO();
        operationNoteWSDTO.setClientNotes(clientNoteRepository.findByClientId(clientDBModel.getId()));
        return operationNoteWSDTO;
    }


    public ApiOperationCampaignWSDTO mapApiOperationCampaignWSDTO(CampaignDBModel campaignDBModel, ProcessDBModel processDBModel) {

        ApiOperationCampaignWSDTO operationCampaignWSDTO = new ApiOperationCampaignWSDTO();
        operationCampaignWSDTO.setOperationCampaign(campaignDBModel);
        operationCampaignWSDTO.setOperationProcess(processDBModel);
        return operationCampaignWSDTO;
    }

    public List<ApiOperationActivityWSDTO> mapApiOperationActivities(OperationDBModel operationDBModel) {

        if (operationDBModel != null && operationDBModel.getActivities() != null) {
            List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();
            for (int i = 0; i < operationDBModel.getActivities().size(); i++) {
                operationActivityWSDTOS.add(new ApiOperationActivityWSDTO(operationDBModel.getActivities().get(i)));
            }
            return operationActivityWSDTOS;
        }
        return null;
    }


    public ApiOperationScenarioWSDTO mapApiOperationScenarioWSDTO(long sessionId,long clientId,String processId) {

        ApiOperationScenarioWSDTO operationScenarioWSDTO = new ApiOperationScenarioWSDTO();
        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();
        List<ApiScenarioExecutionWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
            if (scenarioDBModel.isPresent()) {
                scenarioWSDTOS.add(mapApiScenarioWSDTO(scenarioDBModel.get(),processScenarioDBModel));
            }
        }
        operationScenarioWSDTO.setScenarios(scenarioWSDTOS);

        List<ScenarioExecutionDBModel> scenarioExecutionDBModels = scenarioExecuteRepository.findBySessionIdAndClientIdAndProcessId(sessionId,clientId,processId);
        for (ScenarioExecutionDBModel scenarioExecutionDBModel : scenarioExecutionDBModels) {
            scenarioExecutionWSDTOS.add(mapApiScenarioExecutionWSDTO(scenarioExecutionDBModel));
        }
        operationScenarioWSDTO.setScenarioExecutions(scenarioExecutionWSDTOS);

        return operationScenarioWSDTO;
    }


    public ApiScenarioWSDTO mapApiScenarioWSDTO(ScenarioDBModel scenarioDBModel,ProcessScenarioDBModel processScenarioDBModel){

        ApiScenarioWSDTO scenarioWSDTO = new ApiScenarioWSDTO();
        scenarioWSDTO.setScenario(scenarioDBModel);
        scenarioWSDTO.setProcessScenario(processScenarioDBModel);
        return scenarioWSDTO;
    }


    public ApiScenarioExecutionWSDTO mapApiScenarioExecutionWSDTO(ScenarioExecutionDBModel scenarioExecutionDBModel){

        ApiScenarioExecutionWSDTO scenarioExecutionWSDTO = new ApiScenarioExecutionWSDTO();
        scenarioExecutionWSDTO.setScenarioExecution(scenarioExecutionDBModel);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioExecutionDBModel.getScenarioId());
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(scenarioExecutionDBModel.getProcessId(),scenarioExecutionDBModel.getScenarioId());
        if (scenarioDBModel.isPresent() && processScenarioDBModels.size()>0){
            scenarioExecutionWSDTO.setScenario(mapApiScenarioWSDTO(scenarioDBModel.get(),processScenarioDBModels.get(0)));
        }
        return scenarioExecutionWSDTO;
    }



    public ApiOperationChannelWSDTO mapApiOperationChannelWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel) {

        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientDBModel.getId());

        ApiOperationChannelWSDTO operationChannelWSDTO = new ApiOperationChannelWSDTO();
        operationChannelWSDTO.setOperationSipCall(mapApiOperationSipCallWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationWappCall(mapApiOperationWappCallWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationSmsMessage(mapApiOperationSmsMessageWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationWappMessage(mapApiOperationWappMessageWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationEmailMessage(mapApiOperationEmailMessageWSDTO(sessionDBModel));
        operationChannelWSDTO.setOperationMessenger(mapApiOperationMessengerWSDTO());
        operationChannelWSDTO.setOperationPushMessage(mapApiOperationPushMessageWSDTO(sessionDBModel));

        return operationChannelWSDTO;
    }


    public ApiOperationSipCallWSDTO mapApiOperationSipCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiSipAccountWSDTO sipAccountWSDTO = getApiSipAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (sipAccountWSDTO != null) {
            ApiOperationSipCallWSDTO operationSipCall = new ApiOperationSipCallWSDTO();
            operationSipCall.setSipAccount(sipAccountWSDTO);
            operationSipCall.setPhones(clientPhones);
            List<SipCallDBModel> activeSipCall = sipCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.ACTIVE_CALL);
            if (activeSipCall.size() > 0) {
                operationSipCall.setSipCall(activeSipCall.get(0));
            }
            operationSipCall.setSipCalls(sipCallRepository.findBySessionId(sessionDBModel.getId()));

            return operationSipCall;
        }
        return null;
    }


    public ApiSipAccountWSDTO getApiSipAccountWSDTO(long agentId, String processId) {

        List<ProcessSipChannelDBModel> sipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        if (sipChannelDBModels.size() > 0 && agentDetails.size() > 0 && agentDetails.get(0).getSipChannel() != null) {

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


    public ApiOperationWappCallWSDTO mapApiOperationWappCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiWappAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (wappAccountWSDTO != null) {
            ApiOperationWappCallWSDTO operationWappCall = new ApiOperationWappCallWSDTO();
            operationWappCall.setWappAccount(wappAccountWSDTO);
            operationWappCall.setPhones(clientPhones);
            List<WappCallDBModel> activeWappCall = wappCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.ACTIVE_CALL);
            if (activeWappCall.size() > 0) {
                operationWappCall.setWappCall(activeWappCall.get(0));
            }
            operationWappCall.setWappCalls(wappCallRepository.findBySessionId(sessionDBModel.getId()));

            return operationWappCall;
        }
        return null;
    }


    public ApiWappAccountWSDTO getApiWappAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<ProcessWappChannelDBModel> wappChannels = processWappChannelRepository.findByProcessId(processId);
        if (agentDetails.size() > 0 && agentDetails.get(0).getWappChannel() != null
                && agentDetails.get(0).getWappChannel().getAccountId() != null && wappChannels.size() > 0) {

            ApiWappAccountWSDTO wappAccountWSDTO = new ApiWappAccountWSDTO();

            wappAccountWSDTO.setAccountId(agentDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setAccount(agentDetails.get(0).getWappChannel().getAccount());
            wappAccountWSDTO.setInstanceKey(agentDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(agentDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(agentDetails.get(0).getWappChannel().getServerUrl());
            wappAccountWSDTO.setAccountDatas(agentDetails.get(0).getWappChannel().getAccountDatas());
            wappAccountWSDTO.setCallStatus(wappChannels.get(0).getCallStatus());
            wappAccountWSDTO.setMessageStatus(wappChannels.get(0).getMessageStatus());
            wappAccountWSDTO.setcDate(wappChannels.get(0).getcDate());
            wappAccountWSDTO.setStatus(wappChannels.get(0).getStatus());

            return wappAccountWSDTO;
        }
        return null;
    }


    public ApiOperationSmsMessageWSDTO mapApiOperationSmsMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiSmsAccountWSDTO smsAccountWSDTO = getApiSmsAccountWSDTO(sessionDBModel.getProcessId());
        if (smsAccountWSDTO != null){

            ApiOperationSmsMessageWSDTO operationSmsMessageWSDTO = new ApiOperationSmsMessageWSDTO();
            operationSmsMessageWSDTO.setSmsAccount(smsAccountWSDTO);
            operationSmsMessageWSDTO.setPhones(clientPhones);
            operationSmsMessageWSDTO.setSmsMessages(smsMessageRepository.findBySessionId(sessionDBModel.getId()));
            operationSmsMessageWSDTO.setSmsTemps(smsMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

            return operationSmsMessageWSDTO;
        }
        return null;
    }


    public ApiSmsAccountWSDTO getApiSmsAccountWSDTO(String processId) {

        List<ProcessSmsChannelDBModel>smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (smsChannelDBModels.size()>0 && smsChannelDBModels.get(0).getSmsAccount() != null) {

            ApiSmsAccountWSDTO smsAccountWSDTO = new ApiSmsAccountWSDTO();

            smsAccountWSDTO.setAccountId(smsChannelDBModels.get(0).getAccountId());
            smsAccountWSDTO.setAccount(smsChannelDBModels.get(0).getSmsAccount().getAccount());
            smsAccountWSDTO.setUserName(smsChannelDBModels.get(0).getSmsAccount().getUserName());
            smsAccountWSDTO.setPassword(smsChannelDBModels.get(0).getSmsAccount().getPassword());
            smsAccountWSDTO.setApiToken(smsChannelDBModels.get(0).getSmsAccount().getApiToken());
            smsAccountWSDTO.setApiUrl(smsChannelDBModels.get(0).getSmsAccount().getApiUrl());
            smsAccountWSDTO.setAccountDatas(smsChannelDBModels.get(0).getSmsAccount().getAccountDatas());
            smsAccountWSDTO.setProvider(smsChannelDBModels.get(0).getSmsAccount().getProvider());
            smsAccountWSDTO.setSmsStatus(smsChannelDBModels.get(0).getSmsStatus());
            smsAccountWSDTO.setcDate(smsChannelDBModels.get(0).getcDate());
            smsAccountWSDTO.setStatus(smsChannelDBModels.get(0).getStatus());

            return smsAccountWSDTO;
        }
        return null;
    }


    public ApiOperationWappMessageWSDTO mapApiOperationWappMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiWappAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(),sessionDBModel.getProcessId());
        if (wappAccountWSDTO != null){

            ApiOperationWappMessageWSDTO operationWappMessageWSDTO = new ApiOperationWappMessageWSDTO();
            operationWappMessageWSDTO.setWappAccount(wappAccountWSDTO);
            operationWappMessageWSDTO.setPhones(clientPhones);
            operationWappMessageWSDTO.setWappMessages(wappMessageRepository.findBySessionId(sessionDBModel.getId()));
            operationWappMessageWSDTO.setWappTemps(wappMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

            return operationWappMessageWSDTO;
        }
        return null;
    }


    public ApiOperationEmailMessageWSDTO mapApiOperationEmailMessageWSDTO(SessionDBModel sessionDBModel) {

        ApiEmailAccountWSDTO emailAccountWSDTO = getApiEmailAccountWSDTO(sessionDBModel.getProcessId());
        if (emailAccountWSDTO != null){
            ApiOperationEmailMessageWSDTO operationEmailMessageWSDTO = new ApiOperationEmailMessageWSDTO();
            operationEmailMessageWSDTO.setEmailAccount(emailAccountWSDTO);
            operationEmailMessageWSDTO.setEmails(clientEmailRepository.findByClientId(sessionDBModel.getClientId()));
            operationEmailMessageWSDTO.setEmailMessages(emailMessageRepository.findBySessionId(sessionDBModel.getId()));
            operationEmailMessageWSDTO.setEmailTemps(emailTempRepository.findByProcessId(sessionDBModel.getProcessId()));

            return operationEmailMessageWSDTO;
        }
        return null;
    }

    public ApiEmailAccountWSDTO getApiEmailAccountWSDTO(String processId) {

        List<ProcessEmailChannelDBModel>emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (emailChannelDBModels.size()>0 && emailChannelDBModels.get(0).getEmailAccount() != null) {
            ApiEmailAccountWSDTO emailAccountWSDTO = new ApiEmailAccountWSDTO();
            emailAccountWSDTO.setAccountId(emailChannelDBModels.get(0).getAccountId());
            emailAccountWSDTO.setAccount(emailChannelDBModels.get(0).getEmailAccount().getAccount());
            emailAccountWSDTO.setAccountDatas(emailChannelDBModels.get(0).getEmailAccount().getAccountDatas());
            emailAccountWSDTO.setProvider(emailChannelDBModels.get(0).getEmailAccount().getProvider());
            emailAccountWSDTO.setEmailStatus(emailChannelDBModels.get(0).getEmailStatus());
            emailAccountWSDTO.setcDate(emailChannelDBModels.get(0).getcDate());
            emailAccountWSDTO.setStatus(emailChannelDBModels.get(0).getStatus());

            return emailAccountWSDTO;
        }
        return null;
    }



    public ApiOperationMessengerWSDTO mapApiOperationMessengerWSDTO() {

        return null;
    }


    public ApiOperationPushMessageWSDTO mapApiOperationPushMessageWSDTO(SessionDBModel sessionDBModel) {

        ApiPushAccountWSDTO pushAccountWSDTO = getApiPushAccountWSDTO(sessionDBModel.getProcessId());
        if (pushAccountWSDTO != null){
            ApiOperationPushMessageWSDTO operationPushMessageWSDTO = new ApiOperationPushMessageWSDTO();
            operationPushMessageWSDTO.setPushAccount(pushAccountWSDTO);
            operationPushMessageWSDTO.setPushMessages(pushMessageRepository.findBySessionId(sessionDBModel.getId()));
            operationPushMessageWSDTO.setPushTemps(pushTempRepository.findByProcessId(sessionDBModel.getProcessId()));

            return operationPushMessageWSDTO;
        }
        return null;
    }


    public ApiPushAccountWSDTO getApiPushAccountWSDTO(String processId) {

        List<ProcessPushChannelDBModel>pushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (pushChannelDBModels.size()>0 && pushChannelDBModels.get(0).getPushAccount() != null) {

            ApiPushAccountWSDTO pushAccountWSDTO = new ApiPushAccountWSDTO();
            pushAccountWSDTO.setAccountId(pushChannelDBModels.get(0).getAccountId());
            pushAccountWSDTO.setAccount(pushChannelDBModels.get(0).getPushAccount().getAccount());
            pushAccountWSDTO.setAccountDatas(pushChannelDBModels.get(0).getPushAccount().getAccountDatas());
            pushAccountWSDTO.setProvider(pushChannelDBModels.get(0).getPushAccount().getProvider());
            pushAccountWSDTO.setPushStatus(pushChannelDBModels.get(0).getPushStatus());
            pushAccountWSDTO.setcDate(pushChannelDBModels.get(0).getcDate());
            pushAccountWSDTO.setStatus(pushChannelDBModels.get(0).getStatus());

            return pushAccountWSDTO;
        }
        return null;
    }



}
