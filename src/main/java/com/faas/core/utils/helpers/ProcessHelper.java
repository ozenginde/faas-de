package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.repo.automation.content.AutomationTempRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessHelper {

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSDTO createProcessDetailsWSDTO(ProcessDBModel processDBModel) {

        ProcessDetailsWSDTO processDetailsWSDTO = new ProcessDetailsWSDTO();
        processDetailsWSDTO.setProcess(processDBModel);
        processDetailsWSDTO.setProcessScenarios(createProcessScenarioWSDTOS(processDBModel));
        processDetailsWSDTO.setProcessTemps(createProcessTempWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessChannels(createProcessChannelWSDTO(processDBModel.getId()));
        processDetailsWSDTO.setProcessAssets(new ArrayList<>());

        return processDetailsWSDTO;
    }


    public List<ProcessScenarioWSDTO> createProcessScenarioWSDTOS(ProcessDBModel processDBModel){

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processDBModel.getId());
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            ProcessScenarioWSDTO processScenarioWSDTO = mapProcessScenarioWSDTO(processScenarioDBModel);
            if (processScenarioWSDTO != null){
                processScenarioWSDTOS.add(processScenarioWSDTO);
            }
        }
        return processScenarioWSDTOS;
    }



    public ProcessScenarioWSDTO mapProcessScenarioWSDTO(ProcessScenarioDBModel processScenarioDBModel){

        ProcessScenarioWSDTO processScenarioWSDTO = new ProcessScenarioWSDTO();
        processScenarioWSDTO.setProcessScenario(processScenarioDBModel);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
        if (scenarioDBModel.isPresent()){
            processScenarioWSDTO.setProcessScenarioDetails(scenarioDBModel.get());
        }
        return processScenarioWSDTO;
    }



    public ProcessTempWSDTO createProcessTempWSDTO(String processId){

        ProcessTempWSDTO processTempWSDTO = new ProcessTempWSDTO();
        List<EmailTempWSDTO>emailTempWSDTOS = new ArrayList<>();
        List<PushTempWSDTO>pushTempWSDTOS = new ArrayList<>();
        List<WappMessageTempWSDTO>wappMessageTempWSDTOS = new ArrayList<>();
        List<SmsMessageTempWSDTO>smsMessageTempWSDTOS = new ArrayList<>();

        List<EmailTempDBModel> emailTempDBModels = emailTempRepository.findByProcessId(processId);
        for (EmailTempDBModel emailTempDBModel : emailTempDBModels) {
            emailTempWSDTOS.add(new EmailTempWSDTO(emailTempDBModel));
        }
        processTempWSDTO.setEmailTemps(emailTempWSDTOS);
        List<PushTempDBModel> pushTempDBModels = pushTempRepository.findByProcessId(processId);
        for (PushTempDBModel pushTempDBModel : pushTempDBModels) {
            pushTempWSDTOS.add(new PushTempWSDTO(pushTempDBModel));
        }
        processTempWSDTO.setPushTemps(pushTempWSDTOS);
        List<SmsMessageTempDBModel>smsMessageTempDBModels = smsMessageTempRepository.findByProcessId(processId);
        for (SmsMessageTempDBModel smsMessageTempDBModel : smsMessageTempDBModels) {
            smsMessageTempWSDTOS.add(new SmsMessageTempWSDTO(smsMessageTempDBModel));
        }
        processTempWSDTO.setSmsMessageTemps(smsMessageTempWSDTOS);
        List<WappMessageTempDBModel>wappMessageTempDBModels = wappMessageTempRepository.findByProcessId(processId);
        for (WappMessageTempDBModel wappMessageTempDBModel : wappMessageTempDBModels) {
            wappMessageTempWSDTOS.add(new WappMessageTempWSDTO(wappMessageTempDBModel));
        }
        processTempWSDTO.setWappMessageTemps(wappMessageTempWSDTOS);

        return processTempWSDTO;
    }



    public ProcessChannelWSDTO createProcessChannelWSDTO(String processId){

        ProcessChannelWSDTO processChannelWSDTO = new ProcessChannelWSDTO();
        List<ProcessSipChannelDBModel> sipChannelDBModels =  processSipChannelRepository.findByProcessId(processId);
        if (sipChannelDBModels.size()>0){
            processChannelWSDTO.setSipChannel(new ProcessSipChannelWSDTO(sipChannelDBModels.get(0)));
        }
        List<ProcessSmsChannelDBModel> smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (smsChannelDBModels.size()>0){
            processChannelWSDTO.setSmsChannel(new ProcessSmsChannelWSDTO(smsChannelDBModels.get(0)));
        }
        List<ProcessWappChannelDBModel> wappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (wappChannelDBModels.size()>0){
            processChannelWSDTO.setWappChannel(new ProcessWappChannelWSDTO(wappChannelDBModels.get(0)));
        }
        List<ProcessEmailChannelDBModel> emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (emailChannelDBModels.size()>0){
            processChannelWSDTO.setEmailChannel(new ProcessEmailChannelWSDTO(emailChannelDBModels.get(0)));
        }
        List<ProcessPushChannelDBModel> pushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (pushChannelDBModels.size()>0){
            processChannelWSDTO.setPushChannel(new ProcessPushChannelWSDTO(pushChannelDBModels.get(0)));
        }
        return processChannelWSDTO;
    }



}
