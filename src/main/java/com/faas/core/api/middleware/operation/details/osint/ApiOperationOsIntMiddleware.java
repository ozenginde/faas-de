package com.faas.core.api.middleware.operation.details.osint;

import com.faas.core.api.framework.operation.details.osint.ApiOperationOsIntFramework;
import com.faas.core.api.model.ws.operation.details.osint.ApiOperationOsIntWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationOsIntMiddleware {


    @Autowired
    ApiOperationOsIntFramework apiOperationOsIntFramework;


    public ApiOperationOsIntWSModel apiGetOperationOsInt(long agentId, long sessionId, long clientId) {

        ApiOperationOsIntWSModel response = new ApiOperationOsIntWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationOsInt");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
