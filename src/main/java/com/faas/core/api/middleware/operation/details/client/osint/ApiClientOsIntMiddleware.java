package com.faas.core.api.middleware.operation.details.client.osint;

import com.faas.core.api.framework.operation.details.client.osint.ApiClientOsIntFramework;
import com.faas.core.api.model.ws.operation.details.client.osint.ApiClientOsIntWSModel;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiClientOsIntWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiClientOsIntMiddleware {


    @Autowired
    ApiClientOsIntFramework apiClientOsIntFramework;


    public ApiClientOsIntWSModel apiGetClientOsInt(long agentId, long sessionId, long clientId) {

        ApiClientOsIntWSModel response = new ApiClientOsIntWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiClientOsIntWSDTO clientOsIntWSDTO = apiClientOsIntFramework.apiGetClientOsIntService();
        if (clientOsIntWSDTO != null){
            response.setClientOsInt(clientOsIntWSDTO);
        }

        general.setOperation("apiGetClientOsInt");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
