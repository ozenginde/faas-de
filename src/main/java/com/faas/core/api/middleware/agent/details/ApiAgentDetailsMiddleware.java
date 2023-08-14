package com.faas.core.api.middleware.agent.details;

import com.faas.core.api.framework.agent.details.ApiAgentDetailsFramework;
import com.faas.core.api.model.ws.agent.details.ApiAgentDetailsWSModel;
import com.faas.core.api.model.ws.agent.details.ApiAgentInfoWSModel;
import com.faas.core.api.model.ws.agent.details.ApiAgentSipAccountWSModel;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.api.model.ws.agent.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiAgentDetailsMiddleware {


    @Autowired
    ApiAgentDetailsFramework apiAgentDetailsFramework;


    public ApiAgentDetailsWSModel apiGetAgentDetails(long agentId) {

        ApiAgentDetailsWSModel response = new ApiAgentDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentDetailsWSDTO agentDetailsWSDTO = apiAgentDetailsFramework.apiGetAgentDetailsService(agentId);
        if (agentDetailsWSDTO != null) {
            response.setApiAgentDetails(agentDetailsWSDTO);
        }

        general.setOperation("apiGetAgentDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAgentInfoWSModel apiGetAgentInfos(long agentId) {

        ApiAgentInfoWSModel response = new ApiAgentInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiAgentInfoWSDTO>apiAgentInfoWSDTOS = new ArrayList<>();

        ApiAgentInfoWSDTO agentInfoWSDTO = apiAgentDetailsFramework.apiGetAgentInfosService(agentId);
        if (agentInfoWSDTO != null) {
            apiAgentInfoWSDTOS.add(agentInfoWSDTO);
        }

        response.setAgentInfos(apiAgentInfoWSDTOS);
        general.setOperation("apiGetAgentInfos");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAgentSipAccountWSModel apiGetAgentSipAccount(long agentId, String processId) {

        ApiAgentSipAccountWSModel response = new ApiAgentSipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentSipAccountWSDTO agentSipAccountWSDTO = apiAgentDetailsFramework.apiGetAgentSipAccountService(agentId,processId);
        if (agentSipAccountWSDTO != null){
            response.setAgentSipAccount(agentSipAccountWSDTO);
        }

        general.setOperation("apiGetAgentSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
