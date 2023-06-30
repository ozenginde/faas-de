package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.process.details.channel.content.dao.EmailAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.PushAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.SmsAccountDAO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ChannelMapper {


    @Autowired
    AppUtils appUtils;


    public SmsAccountDAO mapProcessSmsAccountDAO(SmsAccountDBModel smsAccountDBModel) {

        SmsAccountDAO smsAccountDAO = new SmsAccountDAO();
        smsAccountDAO.setAccountId(smsAccountDBModel.getId());
        smsAccountDAO.setAccount(smsAccountDBModel.getAccountName());
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
        emailAccountDAO.setAccount(emailAccountDBModel.getAccountName());
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
        pushAccountDAO.setAccount(pushAccountDBModel.getAccountName());
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
