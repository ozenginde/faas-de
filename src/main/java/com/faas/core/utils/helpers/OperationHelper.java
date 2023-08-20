package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiMessengerAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiOperationMessengerWSDTO;
import com.faas.core.api.model.ws.operation.channel.push.dto.ApiOperationPushMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.push.dto.ApiPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiClientNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientNoteDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.scenario.ScenarioExecutionDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessEmailChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessPushChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.flow.FlowRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecutionRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class OperationHelper {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    FlowRepository flowRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushMessageRepository pushMessageRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioExecutionRepository scenarioExecutionRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    AppUtils appUtils;



    public ApiSipAccountWSDTO createApiSipCallAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiSipAccountWSDTO sipCallAccountWSDTO = new ApiSipAccountWSDTO();

        return null;
    }


    public ApiWappAccountWSDTO createApiWappCallAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiWappAccountWSDTO wappCallAccountWSDTO = new ApiWappAccountWSDTO();
        List<ProcessWappChannelDBModel> processWappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!processWappChannels.isEmpty()){
            wappCallAccountWSDTO.setCallStatus(processWappChannels.get(0).getCallStatus());
        }

        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (!userDetails.isEmpty() && userDetails.get(0).getWappChannel() != null){
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
            operationDBModel.setOperationResult(AppConstant.RESULT_EMPTY);
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

        if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
            List<InquiryDBModel> inquiryDBModels = inquiryRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
            if (!inquiryDBModels.isEmpty()){
                operationDetailsWSDTO.setOperationInquiry(inquiryDBModels.get(0));
            }
        }
        if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
            List<FlowDBModel> flowDBModels = flowRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
            if (!flowDBModels.isEmpty()){
                operationDetailsWSDTO.setOperationFlow(flowDBModels.get(0));
            }
        }
        operationDetailsWSDTO.setOperationClient(mapApiOperationClientWSDTO(clientDBModel));
        operationDetailsWSDTO.setClientOsInts(mapApiClientOsIntWSDTOS(clientDBModel));
        operationDetailsWSDTO.setClientNotes(mapApiOperationNoteWSDTO(clientDBModel));
        operationDetailsWSDTO.setOperationCampaign(mapApiOperationCampaignWSDTO(campaignDBModel,processDBModel));
        operationDetailsWSDTO.setOperationActivities(mapApiOperationActivities(operationDBModel));
        operationDetailsWSDTO.setOperationScenario(mapApiOperationScenarioWSDTO(sessionDBModel.getId(),sessionDBModel.getProcessId()));
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


    public List<ApiClientOsIntWSDTO> mapApiClientOsIntWSDTOS(ClientDBModel clientDBModel) {

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = new ArrayList<>();
        return clientOsIntWSDTOS;
    }

    public List<ApiClientNoteWSDTO> mapApiOperationNoteWSDTO(ClientDBModel clientDBModel) {

        List<ApiClientNoteWSDTO> clientNoteWSDTOS = new ArrayList<>();
        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByClientId(clientDBModel.getId());
        for (ClientNoteDBModel clientNoteDBModel : clientNoteDBModels) {
            clientNoteWSDTOS.add(new ApiClientNoteWSDTO(clientNoteDBModel));
        }
        return clientNoteWSDTOS;
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


    public ApiOperationScenarioWSDTO mapApiOperationScenarioWSDTO(long sessionId, String processId) {

        ApiOperationScenarioWSDTO operationScenarioWSDTO = new ApiOperationScenarioWSDTO();
        operationScenarioWSDTO.setScenarios(mapApiScenarioWSDTOS(processScenarioRepository.findByProcessId(processId)));
        operationScenarioWSDTO.setScenarioExecutions(mapApiScenarioExecutionWSDTOS(scenarioExecutionRepository.findBySessionIdAndProcessId(sessionId,processId)));
        return operationScenarioWSDTO;
    }


    public List<ApiScenarioWSDTO> mapApiScenarioWSDTOS(List<ProcessScenarioDBModel> processScenarioDBModels){

        List<ApiScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
            if (scenarioDBModel.isPresent()) {
                ApiScenarioWSDTO scenarioWSDTO = new ApiScenarioWSDTO();
                scenarioWSDTO.setProcessScenario(processScenarioDBModel);
                scenarioWSDTO.setScenario(scenarioDBModel.get());
                scenarioWSDTOS.add(scenarioWSDTO);
            }
        }
        return scenarioWSDTOS;
    }


    public List<ApiScenarioExecutionWSDTO> mapApiScenarioExecutionWSDTOS(List<ScenarioExecutionDBModel> scenarioExecutionDBModels){

        List<ApiScenarioExecutionWSDTO> scenarioExecutionWSDTOS = new ArrayList<>();
        for (ScenarioExecutionDBModel scenarioExecutionDBModel : scenarioExecutionDBModels) {
            scenarioExecutionWSDTOS.add(new ApiScenarioExecutionWSDTO(scenarioExecutionDBModel));
        }
        return scenarioExecutionWSDTOS;
    }


    public ApiOperationChannelWSDTO mapApiOperationChannelWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel) {

        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientDBModel.getId());

        ApiOperationChannelWSDTO operationChannelWSDTO = new ApiOperationChannelWSDTO();
        operationChannelWSDTO.setOperationSipCall(channelHelper.mapApiOperationSipCallWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationWappCall(mapApiOperationWappCallWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationSmsMessage(mapApiOperationSmsMessageWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationWappMessage(mapApiOperationWappMessageWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationEmail(mapApiOperationEmailWSDTO(sessionDBModel));
        operationChannelWSDTO.setOperationMessenger(mapApiOperationMessengerWSDTO());
        operationChannelWSDTO.setOperationPushMessage(mapApiOperationPushMessageWSDTO(sessionDBModel));

        return operationChannelWSDTO;
    }


    public ApiOperationWappCallWSDTO mapApiOperationWappCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiWappAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (wappAccountWSDTO != null) {
            ApiOperationWappCallWSDTO operationWappCall = new ApiOperationWappCallWSDTO();
            operationWappCall.setWappAccount(wappAccountWSDTO);
            operationWappCall.setPhones(clientPhones);
            List<WappCallDBModel> activeWappCall = wappCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.ACTIVE_CALL);
            if (!activeWappCall.isEmpty()) {
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
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null && !wappChannels.isEmpty()) {

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

        ApiOperationSmsMessageWSDTO operationSmsMessageWSDTO = new ApiOperationSmsMessageWSDTO();
        ApiSmsAccountWSDTO smsAccountWSDTO = getApiSmsAccountWSDTO(sessionDBModel.getProcessId());
        if (smsAccountWSDTO != null){
            operationSmsMessageWSDTO.setSmsAccount(smsAccountWSDTO);
        }
        operationSmsMessageWSDTO.setPhones(clientPhones);
        operationSmsMessageWSDTO.setSmsMessages(smsMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationSmsMessageWSDTO.setSmsTemps(smsMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

        return operationSmsMessageWSDTO;
    }


    public ApiSmsAccountWSDTO getApiSmsAccountWSDTO(String processId) {

        List<ProcessSmsChannelDBModel>smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!smsChannelDBModels.isEmpty() && smsChannelDBModels.get(0).getSmsAccount() != null) {

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

        ApiOperationWappMessageWSDTO operationWappMessageWSDTO = new ApiOperationWappMessageWSDTO();
        ApiWappAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(),sessionDBModel.getProcessId());
        if (wappAccountWSDTO != null){
            operationWappMessageWSDTO.setWappAccount(wappAccountWSDTO);
        }
        operationWappMessageWSDTO.setPhones(clientPhones);
        operationWappMessageWSDTO.setWappMessages(wappMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationWappMessageWSDTO.setWappTemps(wappMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

        return operationWappMessageWSDTO;
    }


    public ApiEmailAccountWSDTO getApiEmailAccountWSDTO(String processId) {

        List<ProcessEmailChannelDBModel>emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!emailChannelDBModels.isEmpty() && emailChannelDBModels.get(0).getEmailAccount() != null) {

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


    public ApiOperationEmailWSDTO mapApiOperationEmailWSDTO(SessionDBModel sessionDBModel) {

        ApiOperationEmailWSDTO operationEmailWSDTO = new ApiOperationEmailWSDTO();

        ApiEmailAccountWSDTO emailAccountWSDTO = getApiEmailAccountWSDTO(sessionDBModel.getProcessId());
        if (emailAccountWSDTO != null){
            operationEmailWSDTO.setEmailAccount(emailAccountWSDTO);
        }
        operationEmailWSDTO.setEmails(clientEmailRepository.findByClientId(sessionDBModel.getClientId()));
        operationEmailWSDTO.setEmailMessages(emailMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationEmailWSDTO.setEmailTemps(emailTempRepository.findByProcessId(sessionDBModel.getProcessId()));

        return operationEmailWSDTO;
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
        if (!pushChannelDBModels.isEmpty() && pushChannelDBModels.get(0).getPushAccount() != null) {

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
