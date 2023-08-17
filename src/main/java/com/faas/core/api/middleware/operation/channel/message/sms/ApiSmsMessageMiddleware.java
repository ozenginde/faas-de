package com.faas.core.api.middleware.operation.channel.message.sms;

import com.faas.core.api.framework.operation.channel.message.sms.ApiSmsMessageFramework;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiOperationSmsWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiSmsTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.ApiSmsWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiSmsMessageMiddleware {


    @Autowired
    ApiSmsMessageFramework apiSmsMessageFramework;


    public ApiOperationSmsWSModel apiGetOperationSms(long agentId, long sessionId, long clientId) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsWSDTO operationSmsWSDTO = apiSmsMessageFramework.apiGetOperationSmsService(agentId,sessionId,clientId);
        if (operationSmsWSDTO != null){
            response.setOperationSms(operationSmsWSDTO);
        }

        general.setOperation("apiGetOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsWSModel apiGetSmss(long agentId, long sessionId, long clientId, String processId) {

        ApiSmsWSModel response = new ApiSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSmsWSDTO> smsWSDTOS = apiSmsMessageFramework.apiGetSmssService(agentId,sessionId,clientId,processId);
        if (smsWSDTOS != null){
            response.setSmss(smsWSDTOS);
        }

        general.setOperation("apiGetSmss");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsWSModel apiGetSms(long agentId, long sessionId, long clientId, String processId, String messageId) {

        ApiSmsWSModel response = new ApiSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsWSDTO> smsWSDTOS = new ArrayList<>();

        ApiSmsWSDTO smsWSDTO = apiSmsMessageFramework.apiGetSmsService(agentId,sessionId,clientId,processId,messageId);
        if (smsWSDTO != null){
            smsWSDTOS.add(smsWSDTO);
        }

        response.setSmss(smsWSDTOS);
        general.setOperation("apiGetSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsWSModel apiSendSms(long agentId, long sessionId, long clientId, String processId, String tempId, long numberId) throws IOException {

        ApiSmsWSModel response = new ApiSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsWSDTO> smsWSDTOS = new ArrayList<>();

        ApiSmsWSDTO smsWSDTO = apiSmsMessageFramework.apiSendSmsService();
        if (smsWSDTO != null){
            smsWSDTOS.add(smsWSDTO);
        }

        response.setSmss(smsWSDTOS);
        general.setOperation("apiSendSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsWSModel apiUpdateSms(long agentId, long sessionId, long clientId, String processId, String messageId) {

        ApiSmsWSModel response = new ApiSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsWSDTO> smsWSDTOS = new ArrayList<>();

        ApiSmsWSDTO smsWSDTO = apiSmsMessageFramework.apiUpdateSmsService(agentId,sessionId,clientId,processId,messageId);
        if (smsWSDTO != null){
            smsWSDTOS.add(smsWSDTO);
        }

        response.setSmss(smsWSDTOS);
        general.setOperation("apiUpdateSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsWSModel apiRemoveSms(long agentId, long sessionId, long clientId, String processId, String messageId) {

        ApiSmsWSModel response = new ApiSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsWSDTO> smsWSDTOS = new ArrayList<>();

        ApiSmsWSDTO smsWSDTO = apiSmsMessageFramework.apiRemoveSmsService(agentId,sessionId,clientId,processId,messageId);
        if (smsWSDTO != null){
            smsWSDTOS.add(smsWSDTO);
        }

        response.setSmss(smsWSDTOS);
        general.setOperation("apiRemoveSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ApiSmsTempWSModel apiGetSmsTemps(long agentId, long sessionId, long clientId, String processId) {

        ApiSmsTempWSModel response = new ApiSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSmsTempWSDTO smsTempWSDTO = apiSmsMessageFramework.apiGetSmsTempsService(agentId,sessionId,clientId,processId);
        if (smsTempWSDTO != null){
            response.setSmsTemp(smsTempWSDTO);
        }

        general.setOperation("apiGetSmsTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsTempWSModel apiGetSmsTemp(long agentId, long sessionId, long clientId, String processId, String tempId) {

        ApiSmsTempWSModel response = new ApiSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSmsTempWSDTO smsTempWSDTO = apiSmsMessageFramework.apiGetSmsTempService(agentId,sessionId,clientId,processId,tempId);
        if (smsTempWSDTO != null){
            response.setSmsTemp(smsTempWSDTO);
        }

        general.setOperation("apiGetSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
