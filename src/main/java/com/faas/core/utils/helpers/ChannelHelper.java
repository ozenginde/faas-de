package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.operation.channel.dao.SmsMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChannelHelper {

    @Autowired
    AppUtils appUtils;


    public SmsMessageDAO fillSmsMessageDAO(SmsMessageTempDBModel smsMessageTempDBModel, ProcessSmsChannelDBModel processSmsChannelDBModel){

        SmsMessageDAO smsMessageDAO = new SmsMessageDAO();

        smsMessageDAO.setMessageType(smsMessageTempDBModel.getId());
        smsMessageDAO.setSmsTitle(smsMessageTempDBModel.getSmsTitle());
        smsMessageDAO.setSmsBody(smsMessageTempDBModel.getSmsBody());
        smsMessageDAO.setSenderId(smsMessageTempDBModel.getSenderId());
        smsMessageDAO.setMessageType(smsMessageTempDBModel.getMessageType());
        smsMessageDAO.setAccountId(processSmsChannelDBModel.getAccountId());

        return smsMessageDAO;
    }




}
