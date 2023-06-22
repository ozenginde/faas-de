package com.faas.core.api.middleware.operation.channel.call.sip;

import com.faas.core.api.framework.operation.channel.call.sip.ApiSipCallFramework;
import com.faas.core.api.model.ws.operation.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiSipCallMiddleware {


    @Autowired
    ApiSipCallFramework apiSipCallFramework;


    public ApiOperationSipCallWSModel apiGetOperationSipCall(long agentId,long sessionId,long clientId,String processId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiSipCallFramework.apiGetOperationSipCallService(agentId,sessionId,clientId,processId);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiGetOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationSipCallWSModel apiGetSipCall(long agentId,long sessionId,long clientId,String processId,String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiSipCallFramework.apiGetSipCallService(agentId,sessionId,clientId,processId,callId);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiGetSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiCreateSipCall(long agentId,long sessionId,long clientId,String processId,long numberId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiSipCallFramework.apiCreateSipCallService(agentId,sessionId,clientId,processId,numberId);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiCreateSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiUpdateSipCall(long agentId,long sessionId,long clientId,String processId, String callId,String callState) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiSipCallFramework.apiUpdateSipCallService(agentId,sessionId,clientId,processId,callId,callState);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiUpdateSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiRemoveSipCall(long agentId,long sessionId,long clientId,String processId,String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiSipCallFramework.apiRemoveSipCallService(agentId,sessionId,clientId,processId,callId);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiRemoveSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
