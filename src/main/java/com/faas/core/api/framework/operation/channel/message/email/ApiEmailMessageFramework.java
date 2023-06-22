package com.faas.core.api.framework.operation.channel.message.email;

import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailMessageWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiEmailMessageFramework {

    @Autowired
    AppUtils appUtils;


    public ApiOperationEmailMessageWSDTO apiGetOperationEmailMessagesService(long agentId, long sessionId) {

        return null;
    }



    public ApiEmailMessageWSDTO apiGetEmailMessagesService() {

        return null;
    }


    public ApiEmailMessageWSDTO apiGetEmailMessageService() {

        return null;
    }


    public ApiEmailMessageWSDTO apiSendEmailMessageService() {

        return null;
    }


    public ApiEmailMessageWSDTO apiUpdateEmailMessageService() {

        return null;
    }


    public ApiEmailMessageWSDTO apiRemoveEmailMessageService() {

        return null;
    }


    public ApiEmailMessageWSDTO apiGetEmailMessageTempsService() {

        return null;
    }


    public ApiEmailMessageWSDTO apiGetEmailMessageTempService() {

        return null;
    }



}
