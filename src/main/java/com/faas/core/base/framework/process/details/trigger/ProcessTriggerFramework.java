package com.faas.core.base.framework.process.details.trigger;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.details.trigger.ProcessTriggerDBModel;
import com.faas.core.base.model.db.process.details.trigger.dao.SmsTriggerDAO;
import com.faas.core.base.model.db.process.details.trigger.dao.WappTriggerDAO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.process.details.trigger.ProcessTriggerRepository;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProcessTriggerFramework {

    @Autowired
    ProcessTriggerRepository processTriggerRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessTriggerWSDTO getProcessTriggerService(long userId, String processId) {

        List<ProcessTriggerDBModel> processTriggerDBModels = processTriggerRepository.findByProcessId(processId);
        if (processTriggerDBModels.size()>0){
            return new ProcessTriggerWSDTO(processTriggerDBModels.get(0));
        }
        return null;
    }


    public ProcessTriggerWSDTO createSmsTriggerService(long userId,String processId,String title,String body,String senderId,String triggerType,String accountId) {

        SmsTriggerDAO smsTriggerDAO = createSmsTriggerDAO(title,body,senderId,triggerType,accountId);
        if (smsTriggerDAO != null){
            processTriggerRepository.deleteAll(processTriggerRepository.findByProcessId(processId));

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setSmsTrigger(smsTriggerDAO);
            processTriggerDBModel.setTriggerType(triggerType);
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }


    public SmsTriggerDAO createSmsTriggerDAO(String title,String body,String senderId,String triggerType,String accountId){

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){

            SmsTriggerDAO smsTriggerDAO = new SmsTriggerDAO();
            smsTriggerDAO.setId(appUtils.generateUUID());
            smsTriggerDAO.setAccountId(accountId);
            smsTriggerDAO.setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerDAO.setTitle(title);
            smsTriggerDAO.setBody(body);
            smsTriggerDAO.setSenderId(senderId);
            smsTriggerDAO.setMessageType(triggerType);
            smsTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
            smsTriggerDAO.setStatus(1);

            return smsTriggerDAO;
        }
        return null;
    }



    public ProcessTriggerWSDTO removeSmsTriggerService(long userId,String processId) {

        List<ProcessTriggerDBModel> processTriggerDBModels = processTriggerRepository.findByProcessId(processId);
        if (processTriggerDBModels.size()>0){
            processTriggerRepository.deleteAll(processTriggerDBModels);
            return new ProcessTriggerWSDTO(processTriggerDBModels.get(0));
        }
        return null;
    }


    public ProcessTriggerWSDTO createWappTriggerService(long userId,String processId,String title,String body,String triggerType,String accountId) {

        WappTriggerDAO wappTriggerDAO = createWappTriggerDAO(title,body,triggerType,accountId);
        if (wappTriggerDAO != null){
            processTriggerRepository.deleteAll(processTriggerRepository.findByProcessId(processId));

            ProcessTriggerDBModel processTriggerDBModel = new ProcessTriggerDBModel();
            processTriggerDBModel.setProcessId(processId);
            processTriggerDBModel.setWappTrigger(wappTriggerDAO);
            processTriggerDBModel.setTriggerType(triggerType);
            processTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processTriggerDBModel.setStatus(1);

            return new ProcessTriggerWSDTO(processTriggerRepository.save(processTriggerDBModel));
        }
        return null;
    }


    public WappTriggerDAO createWappTriggerDAO(String title, String body, String triggerType, String accountId){

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){

            WappTriggerDAO wappTriggerDAO = new WappTriggerDAO();
            wappTriggerDAO.setId(appUtils.generateUUID());
            wappTriggerDAO.setAccountId(accountId);
            wappTriggerDAO.setAccount(wappAccountDBModel.get().getAccount());
            wappTriggerDAO.setTitle(title);
            wappTriggerDAO.setBody(body);
            wappTriggerDAO.setMessageType(triggerType);
            wappTriggerDAO.setcDate(appUtils.getCurrentTimeStamp());
            wappTriggerDAO.setStatus(1);

            return wappTriggerDAO;
        }
        return null;
    }

    public ProcessTriggerWSDTO removeWappTriggerService(long userId,String processId) {

        List<ProcessTriggerDBModel> processTriggerDBModels = processTriggerRepository.findByProcessId(processId);
        if (processTriggerDBModels.size()>0){
            processTriggerRepository.deleteAll(processTriggerDBModels);
            return new ProcessTriggerWSDTO(processTriggerDBModels.get(0));
        }
        return null;
    }

}
