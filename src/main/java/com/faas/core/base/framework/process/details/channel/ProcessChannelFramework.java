package com.faas.core.base.framework.process.details.channel;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.process.details.channel.*;
import com.faas.core.base.model.db.process.details.channel.dao.SmsAccountDAO;
import com.faas.core.base.model.ws.process.details.channel.dto.*;
import com.faas.core.base.repo.channel.account.EmailAccountRepository;
import com.faas.core.base.repo.channel.account.PushAccountRepository;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.process.details.channel.*;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProcessChannelFramework {


    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    PushAccountRepository pushAccountRepository;

    @Autowired
    ChannelMapper channelMapper;

    @Autowired
    AppUtils appUtils;


    public ProcessChannelWSDTO getProcessChannelsService(String processId) {

        ProcessChannelWSDTO processChannelWSDTO = new ProcessChannelWSDTO();
        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (processWappChannelDBModels.size() > 0) {
            processChannelWSDTO.setWappChannel(new ProcessWappChannelWSDTO(processWappChannelDBModels.get(0)));
        }
        List<ProcessSipChannelDBModel> processSipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        if (processSipChannelDBModels.size() > 0) {
            processChannelWSDTO.setSipChannel(new ProcessSipChannelWSDTO(processSipChannelDBModels.get(0)));
        }
        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (processSmsChannelDBModels.size() > 0) {
            processChannelWSDTO.setSmsChannel(new ProcessSmsChannelWSDTO(processSmsChannelDBModels.get(0)));
        }
        List<ProcessEmailChannelDBModel> processEmailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (processEmailChannelDBModels.size() > 0) {
            processChannelWSDTO.setEmailChannel(new ProcessEmailChannelWSDTO(processEmailChannelDBModels.get(0)));
        }
        List<ProcessPushChannelDBModel> processPushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (processPushChannelDBModels.size() > 0) {
            processChannelWSDTO.setPushChannel(new ProcessPushChannelWSDTO(processPushChannelDBModels.get(0)));
        }
        return processChannelWSDTO;
    }


    public ProcessSipChannelWSDTO getProcessSipChannelService(String processId) {

        List<ProcessSipChannelDBModel> processSipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        if (processSipChannelDBModels.size() > 0) {
            return new ProcessSipChannelWSDTO(processSipChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessSipChannelWSDTO createProcessSipChannelService(String processId, String callerId, String sipStatus) {

        List<ProcessSipChannelDBModel> currentSipChannel = processSipChannelRepository.findByProcessId(processId);
        if (currentSipChannel.size() > 0) {
            currentSipChannel.get(0).setCallerId(callerId);
            currentSipChannel.get(0).setSipStatus(sipStatus);
            currentSipChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessSipChannelWSDTO(processSipChannelRepository.save(currentSipChannel.get(0)));
        }

        ProcessSipChannelDBModel processSipChannelDBModel = new ProcessSipChannelDBModel();
        processSipChannelDBModel.setProcessId(processId);
        processSipChannelDBModel.setCallerId(callerId);
        processSipChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processSipChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processSipChannelDBModel.setStatus(1);

        return new ProcessSipChannelWSDTO(processSipChannelRepository.save(processSipChannelDBModel));
    }


    public ProcessSipChannelWSDTO removeProcessSipChannelService(String processId) {

        List<ProcessSipChannelDBModel> processSipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        if (processSipChannelDBModels.size() > 0) {
            processSipChannelRepository.deleteAll(processSipChannelDBModels);
            return new ProcessSipChannelWSDTO(processSipChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessSmsChannelWSDTO getProcessSmsChannelService(String processId) {

        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (processSmsChannelDBModels.size() > 0) {
            return new ProcessSmsChannelWSDTO(processSmsChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessSmsChannelWSDTO createProcessSmsChannelService(String processId, String accountId, String smsStatus) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isEmpty()) {
            return null;
        }
        SmsAccountDAO smsAccountDAO = channelMapper.mapProcessSmsAccountDAO(smsAccountDBModel.get());
        if (smsAccountDAO != null) {
            List<ProcessSmsChannelDBModel> currentSmsChannel = processSmsChannelRepository.findByProcessId(processId);
            if (currentSmsChannel.size() > 0) {

                currentSmsChannel.get(0).setAccountId(accountId);
                currentSmsChannel.get(0).setSmsAccount(smsAccountDAO);
                currentSmsChannel.get(0).setSmsStatus(smsStatus);
                currentSmsChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());
                processSmsChannelRepository.save(currentSmsChannel.get(0));

                return new ProcessSmsChannelWSDTO(currentSmsChannel.get(0));
            }
            ProcessSmsChannelDBModel processSmsChannelDBModel = new ProcessSmsChannelDBModel();
            processSmsChannelDBModel.setProcessId(processId);
            processSmsChannelDBModel.setAccountId(accountId);
            processSmsChannelDBModel.setSmsAccount(smsAccountDAO);
            processSmsChannelDBModel.setSmsStatus(smsStatus);
            processSmsChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processSmsChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processSmsChannelDBModel.setStatus(1);

            return new ProcessSmsChannelWSDTO(processSmsChannelRepository.save(processSmsChannelDBModel));
        }
        return null;
    }


    public ProcessSmsChannelWSDTO removeProcessSmsChannelService(String processId) {

        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (processSmsChannelDBModels.size() > 0) {
            processSmsChannelRepository.deleteAll(processSmsChannelDBModels);
            return new ProcessSmsChannelWSDTO(processSmsChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessWappChannelWSDTO getProcessWappChannelService(String processId) {

        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (processWappChannelDBModels.size() > 0) {
            return new ProcessWappChannelWSDTO(processWappChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessWappChannelWSDTO createProcessWappChannelService(String processId, String callStatus, String messageStatus) {

        List<ProcessWappChannelDBModel> currentWappChannels = processWappChannelRepository.findByProcessId(processId);
        if (currentWappChannels.size() > 0) {
            currentWappChannels.get(0).setCallStatus(callStatus);
            currentWappChannels.get(0).setMessageStatus(messageStatus);
            currentWappChannels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessWappChannelWSDTO(processWappChannelRepository.save(currentWappChannels.get(0)));
        }

        ProcessWappChannelDBModel processWappChannelDBModel = new ProcessWappChannelDBModel();

        processWappChannelDBModel.setProcessId(processId);
        processWappChannelDBModel.setCallStatus(callStatus);
        processWappChannelDBModel.setMessageStatus(messageStatus);
        processWappChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processWappChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processWappChannelDBModel.setStatus(1);

        return new ProcessWappChannelWSDTO(processWappChannelRepository.save(processWappChannelDBModel));
    }


    public ProcessWappChannelWSDTO removeProcessWappChannelService(String processId) {

        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);
        if (processWappChannelDBModels.size() > 0) {
            processWappChannelRepository.deleteAll(processWappChannelDBModels);
            return new ProcessWappChannelWSDTO(processWappChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessEmailChannelWSDTO getProcessEmailChannelService(String processId) {

        List<ProcessEmailChannelDBModel> processEmailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (processEmailChannelDBModels.size() > 0) {
            return new ProcessEmailChannelWSDTO(processEmailChannelDBModels.get(0));
        }
        return null;
    }

    public ProcessEmailChannelWSDTO createProcessEmailChannelService(String processId, String accountId,String emailStatus) {

        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()) {
            List<ProcessEmailChannelDBModel> currentEmailChannel = processEmailChannelRepository.findByProcessId(processId);
            if (currentEmailChannel.size() > 0) {

                currentEmailChannel.get(0).setAccountId(accountId);
                currentEmailChannel.get(0).setEmailAccount(channelMapper.mapProcessEmailAccountDAO(emailAccountDBModel.get()));
                currentEmailChannel.get(0).setEmailStatus(emailStatus);
                currentEmailChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

                return new ProcessEmailChannelWSDTO(processEmailChannelRepository.save(currentEmailChannel.get(0)));
            }

            ProcessEmailChannelDBModel processEmailChannelDBModel = new ProcessEmailChannelDBModel();
            processEmailChannelDBModel.setProcessId(processId);
            processEmailChannelDBModel.setAccountId(accountId);
            processEmailChannelDBModel.setEmailAccount(channelMapper.mapProcessEmailAccountDAO(emailAccountDBModel.get()));
            processEmailChannelDBModel.setEmailStatus(emailStatus);
            processEmailChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processEmailChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processEmailChannelDBModel.setStatus(1);

            return new ProcessEmailChannelWSDTO(processEmailChannelRepository.save(processEmailChannelDBModel));
        }
        return null;
    }

    public ProcessEmailChannelWSDTO removeProcessEmailChannelService(String processId) {

        List<ProcessEmailChannelDBModel> processEmailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (processEmailChannelDBModels.size() > 0) {
            processEmailChannelRepository.deleteAll(processEmailChannelDBModels);
            return new ProcessEmailChannelWSDTO(processEmailChannelDBModels.get(0));
        }
        return null;
    }



    public ProcessPushChannelWSDTO getProcessPushChannelService(String processId) {

        List<ProcessPushChannelDBModel>processPushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (processPushChannelDBModels.size()>0) {
            return new ProcessPushChannelWSDTO(processPushChannelDBModels.get(0));
        }
        return null;
    }


    public ProcessPushChannelWSDTO createProcessPushChannelService(String processId, String accountId,String pushStatus) {

        Optional<PushAccountDBModel> pushAccountDBModel = pushAccountRepository.findById(accountId);
        if (pushAccountDBModel.isPresent()) {
            List<ProcessPushChannelDBModel> currentPushChannel = processPushChannelRepository.findByProcessId(processId);
            if (currentPushChannel.size() > 0) {

                currentPushChannel.get(0).setAccountId(accountId);
                currentPushChannel.get(0).setPushAccount(channelMapper.mapProcessPushAccountDAO(pushAccountDBModel.get()));
                currentPushChannel.get(0).setPushStatus(pushStatus);
                currentPushChannel.get(0).setuDate(appUtils.getCurrentTimeStamp());

                return new ProcessPushChannelWSDTO(processPushChannelRepository.save(currentPushChannel.get(0)));
            }

            ProcessPushChannelDBModel processPushChannelDBModel = new ProcessPushChannelDBModel();
            processPushChannelDBModel.setProcessId(processId);
            processPushChannelDBModel.setAccountId(accountId);
            processPushChannelDBModel.setPushAccount(channelMapper.mapProcessPushAccountDAO(pushAccountDBModel.get()));
            processPushChannelDBModel.setPushStatus(pushStatus);
            processPushChannelDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processPushChannelDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processPushChannelDBModel.setStatus(1);

            return new ProcessPushChannelWSDTO(processPushChannelRepository.save(processPushChannelDBModel));
        }
        return null;
    }

    public ProcessPushChannelWSDTO removeProcessPushChannelService(String processId) {

        List<ProcessPushChannelDBModel> processPushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (processPushChannelDBModels.size() > 0) {
            processPushChannelRepository.deleteAll(processPushChannelDBModels);
            return new ProcessPushChannelWSDTO(processPushChannelDBModels.get(0));
        }
        return null;
    }


}
