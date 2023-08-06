package com.faas.core.api.middleware.operation.scenario.details;

import com.faas.core.api.framework.operation.scenario.details.ApiScenarioDetailsFramework;
import com.faas.core.api.model.ws.operation.scenario.details.ApiActionWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiAutomationWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioDetailsWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiActionWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiAutomationWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiScenarioDetailsMiddleware {


    @Autowired
    ApiScenarioDetailsFramework apiScenarioDetailsFramework;


    public ApiScenarioDetailsWSModel apiGetScenarioDetails(long agentId, long sessionId, String processId, String scenarioId) {

        ApiScenarioDetailsWSModel response = new ApiScenarioDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiScenarioDetailsWSDTO scenarioDetailsWSDTO = apiScenarioDetailsFramework.apiGetScenarioDetailsService(agentId,sessionId,processId,scenarioId);
        if (scenarioDetailsWSDTO != null){
            response.setScenarioDetails(scenarioDetailsWSDTO);
        }

        general.setOperation("apiGetScenarioDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiActionWSModel apiGetScenarioActions(long agentId, long sessionId, String scenarioId) {

        ApiActionWSModel response = new ApiActionWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiActionWSModel apiGetScenarioAction(long agentId, long sessionId, String processId) {

        ApiActionWSModel response = new ApiActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiActionWSDTO>scenarioActionWSDTOS = new ArrayList<>();



        general.setOperation("apiGetScenarioAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAutomationWSModel apiGetScenarioAutomations(long agentId, long sessionId, String processId) {

        ApiAutomationWSModel response = new ApiAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioAutomations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAutomationWSModel apiGetScenarioAutomation(long agentId, long sessionId, String processId) {

        ApiAutomationWSModel response = new ApiAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiAutomationWSDTO>scenarioAutomations = new ArrayList<>();



        general.setOperation("apiGetScenarioAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
