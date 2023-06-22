package com.faas.core.base.framework.process.details.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.db.channel.settings.PushTypeDBModel;
import com.faas.core.base.model.db.process.details.temp.EmailTempDBModel;
import com.faas.core.base.model.db.process.details.temp.PushTempDBModel;
import com.faas.core.base.model.db.process.details.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.temp.WappMessageTempDBModel;
import com.faas.core.base.model.ws.process.details.temp.dto.EmailTempWSDTO;
import com.faas.core.base.model.ws.process.details.temp.dto.PushTempWSDTO;
import com.faas.core.base.model.ws.process.details.temp.dto.SmsMessageTempWSDTO;
import com.faas.core.base.model.ws.process.details.temp.dto.WappMessageTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.channel.settings.PushTypeRepository;
import com.faas.core.base.repo.process.details.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.temp.WappMessageTempRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProcessTempFramework {


    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    PushTypeRepository pushTypeRepository;

    @Autowired
    AppUtils appUtils;


    public SmsMessageTempWSDTO fillProcessSmsMessageTempWSDTO(SmsMessageTempDBModel smsMessageTempDBModel) {

        SmsMessageTempWSDTO smsMessageTempWSDTO = new SmsMessageTempWSDTO();
        smsMessageTempWSDTO.setSmsMessageTemp(smsMessageTempDBModel);
        return smsMessageTempWSDTO;
    }


    public SmsMessageTempDBModel createProcessSmsMessageTempService(String processId, String title, String body, String senderId, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            SmsMessageTempDBModel smsMessageTempDBModel = new SmsMessageTempDBModel();
            smsMessageTempDBModel.setProcessId(processId);
            smsMessageTempDBModel.setTitle(title);
            smsMessageTempDBModel.setBody(body);
            smsMessageTempDBModel.setSenderId(senderId);
            smsMessageTempDBModel.setTypeId(typeId);
            smsMessageTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            smsMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.setStatus(1);

            return smsMessageTempRepository.save(smsMessageTempDBModel);
        }
        return null;
    }



    public SmsMessageTempDBModel updateProcessSmsMessageTempService(String tempId, String title, String body, String senderId, long typeId) {

        Optional<SmsMessageTempDBModel> smsMessageTempDBModel = smsMessageTempRepository.findById(tempId);
        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (smsMessageTempDBModel.isPresent() && messageTypeDBModel.isPresent()) {

            smsMessageTempDBModel.get().setTitle(title);
            smsMessageTempDBModel.get().setBody(body);
            smsMessageTempDBModel.get().setSenderId(senderId);
            smsMessageTempDBModel.get().setTypeId(typeId);
            smsMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            smsMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsMessageTempDBModel.get().setStatus(1);

            return smsMessageTempRepository.save(smsMessageTempDBModel.get());
        }
        return null;
    }


    public SmsMessageTempDBModel removeProcessSmsMessageTempService(String tempId) {

        Optional<SmsMessageTempDBModel> smsMessageTempDBModel = smsMessageTempRepository.findById(tempId);
        if (smsMessageTempDBModel.isPresent()) {
            smsMessageTempRepository.delete(smsMessageTempDBModel.get());
            return smsMessageTempDBModel.get();
        }
        return null;
    }



    public WappMessageTempWSDTO fillProcessWappMessageTempWSDTO(WappMessageTempDBModel wappMessageTempDBModel) {

        WappMessageTempWSDTO wappMessageTempWSDTO = new WappMessageTempWSDTO();
        wappMessageTempWSDTO.setWappMessageTemp(wappMessageTempDBModel);
        return wappMessageTempWSDTO;
    }


    public WappMessageTempDBModel createProcessWappMessageTempService(String processId, String title, String body, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            WappMessageTempDBModel wappMessageTempDBModel = new WappMessageTempDBModel();
            wappMessageTempDBModel.setProcessId(processId);
            wappMessageTempDBModel.setTitle(title);
            wappMessageTempDBModel.setBody(body);
            wappMessageTempDBModel.setTypeId(typeId);
            wappMessageTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.setStatus(1);

            return wappMessageTempRepository.save(wappMessageTempDBModel);
        }
        return null;
    }

    public WappMessageTempDBModel updateProcessWappMessageTempService(String tempId, String title, String body, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        Optional<WappMessageTempDBModel> wappMessageTempDBModel = wappMessageTempRepository.findById(tempId);
        if (messageTypeDBModel.isPresent() && wappMessageTempDBModel.isPresent()) {

            wappMessageTempDBModel.get().setTitle(title);
            wappMessageTempDBModel.get().setBody(body);
            wappMessageTempDBModel.get().setTypeId(typeId);
            wappMessageTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            wappMessageTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTempDBModel.get().setStatus(1);

            return wappMessageTempRepository.save(wappMessageTempDBModel.get());
        }
        return null;
    }

    public WappMessageTempDBModel removeProcessWappMessageTempService(String tempId) {

        Optional<WappMessageTempDBModel> wappMessageDBModel = wappMessageTempRepository.findById(tempId);
        if (wappMessageDBModel.isPresent()) {
            wappMessageTempRepository.delete(wappMessageDBModel.get());
            return wappMessageDBModel.get();
        }
        return null;
    }


    public EmailTempWSDTO fillProcessEmailTempWSDTO(EmailTempDBModel emailTempDBModel) {

        EmailTempWSDTO emailTempWSDTO = new EmailTempWSDTO();
        emailTempWSDTO.setEmailTemp(emailTempDBModel);
        return emailTempWSDTO;
    }


    public EmailTempDBModel createProcessEmailTempService(String processId, String subject, String body, String footer, String sender, long typeId) {

        EmailTempDBModel emailTempDBModel = new EmailTempDBModel();
        emailTempDBModel.setProcessId(processId);
        emailTempDBModel.setSubject(subject);
        emailTempDBModel.setBody(body);
        emailTempDBModel.setFooter(footer);
        emailTempDBModel.setSender(sender);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){
            emailTempDBModel.setTypeId(typeId);
            emailTempDBModel.setEmailType(emailTypeDBModel.get().getEmailType());
        }
        emailTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
        emailTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
        emailTempDBModel.setStatus(1);

        return emailTempRepository.save(emailTempDBModel);
    }


    public EmailTempDBModel updateProcessEmailTempService(String tempId, String subject, String body, String footer, String sender, long typeId) {

        Optional<EmailTempDBModel> processEmailDBModel = emailTempRepository.findById(tempId);
        if (processEmailDBModel.isPresent()){
            processEmailDBModel.get().setSubject(subject);
            processEmailDBModel.get().setBody(body);
            processEmailDBModel.get().setFooter(footer);
            processEmailDBModel.get().setSender(sender);
            Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
            if (emailTypeDBModel.isPresent()){
                processEmailDBModel.get().setTypeId(typeId);
                processEmailDBModel.get().setEmailType(emailTypeDBModel.get().getEmailType());
            }
            processEmailDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processEmailDBModel.get().setStatus(1);

            return emailTempRepository.save(processEmailDBModel.get());
        }
        return null;
    }


    public EmailTempDBModel removeProcessEmailTempService(String tempId) {

        Optional<EmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()){
            emailTempRepository.delete(emailTempDBModel.get());
            return emailTempDBModel.get();
        }
        return null;
    }



    public PushTempWSDTO fillProcessPushTempWSDTO(PushTempDBModel pushTempDBModel) {

        PushTempWSDTO pushTempWSDTO = new PushTempWSDTO();
        pushTempWSDTO.setPushTemp(pushTempDBModel);
        return pushTempWSDTO;
    }


    public PushTempDBModel createProcessPushTempService(String processId, String header, String body, String footer, String sender, long typeId) {

        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTypeDBModel.isPresent()){

            PushTempDBModel pushTempDBModel = new PushTempDBModel();
            pushTempDBModel.setProcessId(processId);
            pushTempDBModel.setHeader(header);
            pushTempDBModel.setBody(body);
            pushTempDBModel.setFooter(footer);
            pushTempDBModel.setSender(sender);
            pushTempDBModel.setTypeId(pushTypeDBModel.get().getId());
            pushTempDBModel.setPushType(pushTypeDBModel.get().getPushType());
            pushTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.setStatus(1);


            return pushTempRepository.save(pushTempDBModel);
        }
        return null;
    }

    public PushTempDBModel updateProcessPushTempService(String tempId, String header, String body, String footer, String sender, long typeId) {

        Optional<PushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        Optional<PushTypeDBModel> pushTypeDBModel = pushTypeRepository.findById(typeId);
        if (pushTempDBModel.isPresent() && pushTypeDBModel.isPresent()){

            pushTempDBModel.get().setHeader(header);
            pushTempDBModel.get().setBody(body);
            pushTempDBModel.get().setFooter(footer);
            pushTempDBModel.get().setSender(sender);
            pushTempDBModel.get().setTypeId(pushTypeDBModel.get().getId());
            pushTempDBModel.get().setPushType(pushTypeDBModel.get().getPushType());
            pushTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            pushTempDBModel.get().setStatus(1);

            return pushTempRepository.save(pushTempDBModel.get());
        }
        return null;
    }


    public PushTempDBModel removeProcessPushTempService(String tempId) {

        Optional<PushTempDBModel> pushTempDBModel = pushTempRepository.findById(tempId);
        if (pushTempDBModel.isPresent()){
            pushTempRepository.delete(pushTempDBModel.get());
            return pushTempDBModel.get();
        }
        return null;
    }




}
