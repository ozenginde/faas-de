package com.faas.core.api.middleware.operation.channel.message.email;

import com.faas.core.api.framework.operation.channel.message.email.ApiEmailMessageFramework;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiEmailMessageTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiEmailMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiOperationEmailMessageWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiEmailMessageMiddleware {


    @Autowired
    ApiEmailMessageFramework apiEmailMessageFramework;


    public ApiOperationEmailMessageWSModel apiGetOperationEmailMessage(long agentId, long sessionId) {

        ApiOperationEmailMessageWSModel response = new ApiOperationEmailMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationEmailMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailMessageWSModel apiGetEmailMessages(long agentId, long sessionId) {

        ApiEmailMessageWSModel response = new ApiEmailMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmailMessages");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailMessageWSModel apiGetEmailMessage(long agentId, long sessionId) {

        ApiEmailMessageWSModel response = new ApiEmailMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmailMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailMessageWSModel apiSendEmailMessage(long agentId, long sessionId) {

        ApiEmailMessageWSModel response = new ApiEmailMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiSendEmailMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailMessageWSModel apiUpdateEmailMessage(long agentId, long sessionId) {

        ApiEmailMessageWSModel response = new ApiEmailMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateEmailMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiEmailMessageWSModel apiRemoveEmailMessage(long agentId, long sessionId) {

        ApiEmailMessageWSModel response = new ApiEmailMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiRemoveEmailMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiEmailMessageTempWSModel apiGetEmailMessageTemps(long agentId, long sessionId) {

        ApiEmailMessageTempWSModel response = new ApiEmailMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmailMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailMessageTempWSModel apiGetEmailMessageTemp(long agentId, long sessionId) {

        ApiEmailMessageTempWSModel response = new ApiEmailMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmailMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
