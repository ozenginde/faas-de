package com.faas.core.api.middleware.client.details;

import com.faas.core.api.framework.client.details.ApiClientDetailsFramework;
import com.faas.core.api.model.ws.client.details.ApiClientDetailsWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientHookWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientOsIntWSModel;
import com.faas.core.api.model.ws.client.details.dto.ApiClientDetailsWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientHookWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiClientDetailsMiddleware {


    @Autowired
    ApiClientDetailsFramework apiClientDetailsFramework;


    public ApiClientDetailsWSModel apiGetClientDetails(long agentId,long clientId) {

        ApiClientDetailsWSModel response = new ApiClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiClientDetailsWSDTO clientDetailsWSDTO = apiClientDetailsFramework.apiGetClientDetailsService(agentId,clientId);
        if (clientDetailsWSDTO != null){
            response.setClientDetails(clientDetailsWSDTO);
        }

        general.setOperation("apiGetClientDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientHookWSModel apiGetClientHook(long agentId,long clientId) {

        ApiClientHookWSModel response = new ApiClientHookWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientHookWSDTO> clientHookWSDTOS = apiClientDetailsFramework.apiGetClientHookService(agentId,clientId);
        if (clientHookWSDTOS != null){
            response.setClientHooks(clientHookWSDTOS);
        }

        general.setOperation("apiGetClientHook");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientOsIntWSModel apiGetClientOsInt(long agentId,long clientId) {

        ApiClientOsIntWSModel response = new ApiClientOsIntWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = apiClientDetailsFramework.apiGetClientOsIntService(agentId,clientId);
        if (clientOsIntWSDTOS != null){
            response.setClientOsInts(clientOsIntWSDTOS);
        }

        general.setOperation("apiGetClientOsInt");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
