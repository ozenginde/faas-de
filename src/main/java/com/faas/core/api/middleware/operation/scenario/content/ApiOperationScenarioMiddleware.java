package com.faas.core.api.middleware.operation.scenario.content;

import com.faas.core.api.framework.operation.scenario.content.ApiOperationScenarioFramework;
import com.faas.core.api.model.ws.operation.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiScenarioWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationScenarioMiddleware {

    @Autowired
    ApiOperationScenarioFramework apiOperationScenarioFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId, long sessionId,long clientId,String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenarios(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenario(long agentId, long sessionId, long clientId,String processId, String scenarioId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
