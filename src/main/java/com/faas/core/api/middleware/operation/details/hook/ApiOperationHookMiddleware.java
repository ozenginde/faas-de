package com.faas.core.api.middleware.operation.details.hook;

import com.faas.core.api.framework.operation.details.hook.ApiOperationHookFramework;
import com.faas.core.api.model.ws.operation.details.hook.ApiOperationHookWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationHookMiddleware {


    @Autowired
    ApiOperationHookFramework operationHookFramework;


    public ApiOperationHookWSModel apiGetOperationHooks(long agentId, long sessionId, long clientId) {

        ApiOperationHookWSModel response = new ApiOperationHookWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationHooks");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
