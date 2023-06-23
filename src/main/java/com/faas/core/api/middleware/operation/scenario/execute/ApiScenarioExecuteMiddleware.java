package com.faas.core.api.middleware.operation.scenario.execute;

import com.faas.core.api.framework.operation.scenario.execute.ApiScenarioExecuteFramework;
import com.faas.core.api.model.ws.operation.scenario.content.ApiScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.execute.ApiScenarioExecuteWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiScenarioExecuteMiddleware {


    @Autowired
    ApiScenarioExecuteFramework apiScenarioExecuteFramework;


    public ApiScenarioExecuteWSModel apiGetScenarioExecutes(long agentId, long sessionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioExecutes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecuteWSModel apiGetScenarioExecute(long agentId, long sessionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioExecute");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
