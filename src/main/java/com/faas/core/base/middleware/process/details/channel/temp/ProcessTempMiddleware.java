package com.faas.core.base.middleware.process.details.channel.temp;

import com.faas.core.base.framework.process.details.channel.temp.ProcessTempFramework;
import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessTempMiddleware {

    @Autowired
    ProcessTempFramework processTempFramework;

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;


    public ProcessTempWSModel getProcessTemps(long userId, String processId) {

        ProcessTempWSModel response = new ProcessTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTempWSDTO processTempWSDTO = processHelper.createProcessTempWSDTO(processId);
        if (processTempWSDTO != null){
            response.setProcessTemps(processTempWSDTO);
        }

        general.setOperation("getProcessTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel getProcessSmsMessageTemps(long userId, String processId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        List<SmsMessageTempDBModel> smsMessageTempDBModels = smsMessageTempRepository.findByProcessId(processId);
        for (SmsMessageTempDBModel smsMessageTempDBModel : smsMessageTempDBModels) {
            smsMessageTempWSDTOS.add(processTempFramework.fillProcessSmsMessageTempWSDTO(smsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("getProcessSmsMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel getProcessSmsMessageTemp(long userId, String tempId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        Optional<SmsMessageTempDBModel> smsMessageTempDBModel = smsMessageTempRepository.findById(tempId);
        if (smsMessageTempDBModel.isPresent()) {
            smsMessageTempWSDTOS.add(processTempFramework.fillProcessSmsMessageTempWSDTO(smsMessageTempDBModel.get()));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("getProcessSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel createProcessSmsMessageTemp(long userId,String processId, String title, String body, String senderId, long typeId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        SmsMessageTempDBModel smsMessageTempDBModel = processTempFramework.createProcessSmsMessageTempService(processId,title,body,senderId,typeId);
        if (smsMessageTempDBModel != null) {
            smsMessageTempWSDTOS.add(processTempFramework.fillProcessSmsMessageTempWSDTO(smsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("createProcessSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel updateProcessSmsMessageTemp(long userId,String tempId, String title, String body, String senderId, long typeId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        SmsMessageTempDBModel smsMessageTempDBModel = processTempFramework.updateProcessSmsMessageTempService(tempId,title,body,senderId,typeId);
        if (smsMessageTempDBModel != null) {
            smsMessageTempWSDTOS.add(processTempFramework.fillProcessSmsMessageTempWSDTO(smsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("updateProcessSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SmsMessageTempWSModel removeProcessSmsMessageTemp(long userId, String tempId) {

        SmsMessageTempWSModel response = new SmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsMessageTempWSDTO> smsMessageTempWSDTOS = new ArrayList<>();

        SmsMessageTempDBModel smsMessageTempDBModel = processTempFramework.removeProcessSmsMessageTempService(tempId);
        if (smsMessageTempDBModel != null) {
            smsMessageTempWSDTOS.add(processTempFramework.fillProcessSmsMessageTempWSDTO(smsMessageTempDBModel));
        }

        response.setSmsMessageTemps(smsMessageTempWSDTOS);
        general.setOperation("removeProcessSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public WappMessageTempWSModel getProcessWappMessageTemps(long userId, String processId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        List<WappMessageTempDBModel> wappMessageTempDBModels = wappMessageTempRepository.findByProcessId(processId);
        for (WappMessageTempDBModel wappMessageTempDBModel : wappMessageTempDBModels) {
            wappMessageWSDTOS.add(processTempFramework.fillProcessWappMessageTempWSDTO(wappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("getProcessWappMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public WappMessageTempWSModel getProcessWappMessageTemp(long userId, String tempId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        Optional<WappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (wappMessageTempDBModel.isPresent()) {
            wappMessageWSDTOS.add(processTempFramework.fillProcessWappMessageTempWSDTO(wappMessageTempDBModel.get()));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("getProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTempWSModel createProcessWappMessageTemp(long userId, String processId, String title, String body, long typeId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        WappMessageTempDBModel wappMessageTempDBModel = processTempFramework.createProcessWappMessageTempService(processId,title,body,typeId);
        if (wappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processTempFramework.fillProcessWappMessageTempWSDTO(wappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("createProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTempWSModel updateProcessWappMessageTemp(long userId, String tempId, String title, String body, long typeId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        WappMessageTempDBModel wappMessageTempDBModel = processTempFramework.updateProcessWappMessageTempService(tempId,title,body,typeId);
        if (wappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processTempFramework.fillProcessWappMessageTempWSDTO(wappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("updateProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public WappMessageTempWSModel removeProcessWappMessageTemp(long userId, String tempId) {

        WappMessageTempWSModel response = new WappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTempWSDTO> wappMessageWSDTOS = new ArrayList<>();

        WappMessageTempDBModel wappMessageTempDBModel = processTempFramework.removeProcessWappMessageTempService(tempId);
        if (wappMessageTempDBModel != null) {
            wappMessageWSDTOS.add(processTempFramework.fillProcessWappMessageTempWSDTO(wappMessageTempDBModel));
        }

        response.setWappMessageTemps(wappMessageWSDTOS);
        general.setOperation("removeProcessWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel getProcessEmailTemps(long userId, String processId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        List<EmailTempDBModel> emailTempDBModels = emailTempRepository.findByProcessId(processId);
        for (EmailTempDBModel emailTempDBModel : emailTempDBModels) {
            emailTempWSDTOS.add(processTempFramework.fillProcessEmailTempWSDTO(emailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("getProcessEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel getProcessEmailTemp(long userId, String tempId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        Optional<EmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()) {
            emailTempWSDTOS.add(processTempFramework.fillProcessEmailTempWSDTO(emailTempDBModel.get()));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("getProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel createProcessEmailTemp(long userId, String processId, String subject, String body, String footer, String sender, long typeId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        EmailTempDBModel emailTempDBModel = processTempFramework.createProcessEmailTempService(processId,subject,body,footer,sender,typeId);
        if (emailTempDBModel != null) {
            emailTempWSDTOS.add(processTempFramework.fillProcessEmailTempWSDTO(emailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("createProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel updateProcessEmailTemp(long userId, String tempId, String subject, String body, String footer, String sender, long typeId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        EmailTempDBModel emailTempDBModel = processTempFramework.updateProcessEmailTempService(tempId,subject,body,footer,sender,typeId);
        if (emailTempDBModel != null) {
            emailTempWSDTOS.add(processTempFramework.fillProcessEmailTempWSDTO(emailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("updateProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public EmailTempWSModel removeProcessEmailTemp(long userId, String tempId) {

        EmailTempWSModel response = new EmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailTempWSDTO> emailTempWSDTOS = new ArrayList<>();

        EmailTempDBModel emailTempDBModel = processTempFramework.removeProcessEmailTempService(tempId);
        if (emailTempDBModel != null) {
            emailTempWSDTOS.add(processTempFramework.fillProcessEmailTempWSDTO(emailTempDBModel));
        }

        response.setEmailTemps(emailTempWSDTOS);
        general.setOperation("removeProcessEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public PushTempWSModel getProcessPushTemps(long userId, String processId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        List<PushTempDBModel> pushTempDBModels = pushTempRepository.findByProcessId(processId);
        for (PushTempDBModel pushTempDBModel : pushTempDBModels) {
            pushTempWSDTOS.add(processTempFramework.fillProcessPushTempWSDTO(pushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("getProcessPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTempWSModel getProcessPushTemp(long userId, String tempId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        Optional<PushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()) {
            pushTempWSDTOS.add(processTempFramework.fillProcessPushTempWSDTO(pushTempDBModel.get()));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("getProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTempWSModel createProcessPushTemp(long userId,String processId, String header, String body, String footer, String sender, long typeId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        PushTempDBModel pushTempDBModel = processTempFramework.createProcessPushTempService(processId,header,body,footer,sender,typeId);
        if (pushTempDBModel != null) {
            pushTempWSDTOS.add(processTempFramework.fillProcessPushTempWSDTO(pushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("createProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public PushTempWSModel updateProcessPushTemp(long userId, String tempId,String header, String body, String footer, String sender, long typeId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        PushTempDBModel pushTempDBModel = processTempFramework.updateProcessPushTempService(tempId,header,body,footer,sender,typeId);
        if (pushTempDBModel != null) {
            pushTempWSDTOS.add(processTempFramework.fillProcessPushTempWSDTO(pushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("updateProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushTempWSModel removeProcessPushTemp(long userId, String tempId) {

        PushTempWSModel response = new PushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushTempWSDTO> pushTempWSDTOS = new ArrayList<>();

        PushTempDBModel pushTempDBModel = processTempFramework.removeProcessPushTempService(tempId);
        if (pushTempDBModel != null) {
            pushTempWSDTOS.add(processTempFramework.fillProcessPushTempWSDTO(pushTempDBModel));
        }

        response.setPushTemps(pushTempWSDTOS);
        general.setOperation("removeProcessPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
