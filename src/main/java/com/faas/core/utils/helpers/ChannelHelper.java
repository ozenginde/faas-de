package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.operation.channel.dao.SmsMessageDAO;
import com.faas.core.base.model.db.operation.channel.dao.WappMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ChannelHelper {

    @Autowired
    AppUtils appUtils;


    public SmsMessageDAO getSmsMessageDAO(SessionDBModel sessionDBModel, SmsMessageTempDBModel smsMessageTempDBModel, ProcessSmsChannelDBModel processSmsChannelDBModel){

        SmsMessageDAO smsMessageDAO = new SmsMessageDAO();
        smsMessageDAO.setTempId(smsMessageTempDBModel.getId());
        smsMessageDAO.setSmsTitle(smsMessageTempDBModel.getSmsTitle());
        smsMessageDAO.setSmsBody(smsMessageTempDBModel.getSmsBody());
        smsMessageDAO.setSenderId(smsMessageTempDBModel.getSenderId());
        smsMessageDAO.setMessageType(smsMessageTempDBModel.getMessageType());
        smsMessageDAO.setAccountId(processSmsChannelDBModel.getAccountId());
        smsMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return smsMessageDAO;
    }


    public WappMessageDAO getWappMessageDAO(SessionDBModel sessionDBModel, WappMessageTempDBModel wappMessageTempDBModel, UserDetailsDBModel agentDetails){

        WappMessageDAO wappMessageDAO = new WappMessageDAO();
        wappMessageDAO.setTempId(wappMessageTempDBModel.getId());
        wappMessageDAO.setWappTitle(wappMessageTempDBModel.getWappTitle());
        wappMessageDAO.setWappBody(wappMessageTempDBModel.getWappBody());
        wappMessageDAO.setMessageDatas(new ArrayList<>());
        wappMessageDAO.setMessageType(wappMessageTempDBModel.getMessageType());
        wappMessageDAO.setAccountId(agentDetails.getWappChannel().getAccountId());
        wappMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return wappMessageDAO;
    }


}
