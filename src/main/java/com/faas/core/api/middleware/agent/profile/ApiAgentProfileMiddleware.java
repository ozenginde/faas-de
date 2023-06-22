package com.faas.core.api.middleware.agent.profile;

import com.faas.core.api.framework.agent.profile.ApiAgentProfileFramework;
import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.api.model.ws.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiAgentProfileMiddleware {


    @Autowired
    ApiAgentProfileFramework apiAgentProfileFramework;

    @Autowired
    AppUtils appUtils;


    public ApiAgentWSModel agentLogin(String userEmail, String password) {

        ApiAgentWSModel response = new ApiAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiAgentWSDTO> apiAgentWSDTOS = new ArrayList<>();



        response.setAgents(apiAgentWSDTOS);
        general.setOperation("agentLogin");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
