package com.faas.core.api.middleware.operation.channel.call.wapp;

import com.faas.core.api.framework.operation.channel.call.wapp.ApiWappCallFramework;
import com.faas.core.api.model.ws.operation.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiWappCallMiddleware {


    @Autowired
    ApiWappCallFramework apiWappCallFramework;


    public ApiOperationWappCallWSModel apiGetOperationWappCall(long agentId, long sessionId, long clientId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiGetOperationWappCallService(agentId,sessionId,clientId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiGetOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiGetWappCalls(long agentId,long sessionId,String campaignId,String processId ) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiGetWappCallsService(agentId,sessionId,campaignId,processId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiGetWappCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiGetWappCall(long agentId,long sessionId,long clientId ,long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiGetWappCallService(agentId,sessionId,clientId,callId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiGetWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiCreateWappCall(long agentId,long sessionId,long clientId,String processId,long numberId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiCreateWappCallService(agentId,sessionId,clientId,processId,numberId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiCreateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiUpdateWappCall(long agentId,long sessionId,long clientId,long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiUpdateWappCallService(agentId,sessionId,clientId,callId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiUpdateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationWappCallWSModel apiRemoveWappCall(long agentId,long sessionId,long clientId, long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiRemoveWappCallService(agentId,sessionId,clientId,callId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiRemoveWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
