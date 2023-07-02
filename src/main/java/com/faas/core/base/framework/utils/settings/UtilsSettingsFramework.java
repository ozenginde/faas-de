package com.faas.core.base.framework.utils.settings;

import com.faas.core.base.repo.scenario.action.ActionTempRepository;
import com.faas.core.base.repo.assets.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.notification.NotificationRepository;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.scenario.ScenarioExecuteRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UtilsSettingsFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    PushMessageRepository pushMessageRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ScenarioExecuteRepository scenarioExecuteRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessRepository processRepository;


    public void removeAllClientsService() {

        clientRepository.deleteAll();
        clientDataRepository.deleteAll();
        clientEmailRepository.deleteAll();
        clientPhoneRepository.deleteAll();
        clientAddressRepository.deleteAll();
        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        emailMessageRepository.deleteAll();
        pushMessageRepository.deleteAll();
        sipCallRepository.deleteAll();
        smsMessageRepository.deleteAll();
        wappCallRepository.deleteAll();
        wappMessageRepository.deleteAll();
    }


    public void removeAllSessionsService() {

        clientRepository.deleteAll();
        clientDataRepository.deleteAll();
        clientEmailRepository.deleteAll();
        clientPhoneRepository.deleteAll();
        clientAddressRepository.deleteAll();
        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        emailMessageRepository.deleteAll();
        pushMessageRepository.deleteAll();
        sipCallRepository.deleteAll();
        smsMessageRepository.deleteAll();
        wappCallRepository.deleteAll();
        wappMessageRepository.deleteAll();
    }


    public void removeSelectedTablesService(String selected) {

        if (selected.equalsIgnoreCase(AppConstant.SCENARIO_TABLES)){
            scenarioRepository.deleteAll();
        }
        if (selected.equalsIgnoreCase(AppConstant.CAMPAIGN_TABLES)){
            campaignRepository.deleteAll();
        }
        if (selected.equalsIgnoreCase(AppConstant.PROCESS_SCENARIO_TABLES)){
            processScenarioRepository.deleteAll();
        }
    }



    public void cleanSystemTablesService() {

        inquiryRepository.deleteAll();
        notificationRepository.deleteAll();
        actionTempRepository.deleteAll();
        assetRepository.deleteAll();
        processRepository.deleteAll();
        campaignRepository.deleteAll();
        campaignAgentRepository.deleteAll();
        scenarioExecuteRepository.deleteAll();
        processEmailChannelRepository.deleteAll();
        processPushChannelRepository.deleteAll();
        processSipChannelRepository.deleteAll();
        processSmsChannelRepository.deleteAll();
        processWappChannelRepository.deleteAll();
        emailTempRepository.deleteAll();
        pushTempRepository.deleteAll();
        smsMessageTempRepository.deleteAll();
        wappMessageTempRepository.deleteAll();
        processScenarioRepository.deleteAll();
        scenarioRepository.deleteAll();

    }


}
