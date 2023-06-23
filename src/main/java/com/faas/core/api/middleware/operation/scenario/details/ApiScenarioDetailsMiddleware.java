package com.faas.core.api.middleware.operation.scenario.details;

import com.faas.core.api.framework.operation.scenario.details.ApiScenarioDetailsFramework;
import com.faas.core.api.model.ws.operation.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioDetailsWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiScenarioDetailsMiddleware {


    @Autowired
    ApiScenarioDetailsFramework apiScenarioDetailsFramework;


    public ApiScenarioDetailsWSModel apiGetScenarioDetails(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioDetailsWSModel response = new ApiScenarioDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiGetScenarioActions(long agentId, long sessionId, long clientId, String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetActionElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenarioAction(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ApiOperationScenarioWSModel apiGetScenarioAutomations(long agentId, long sessionId,long clientId,String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioAutomations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioWSModel apiGetScenarioAutomation(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarioAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }






}
