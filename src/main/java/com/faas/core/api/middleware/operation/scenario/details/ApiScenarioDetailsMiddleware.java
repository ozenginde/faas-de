package com.faas.core.api.middleware.operation.scenario.details;

import com.faas.core.api.framework.operation.scenario.details.ApiScenarioDetailsFramework;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioActionWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioAutomationWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioDetailsWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioActionWSDTO;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioAutomationWSDTO;
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


    public ApiScenarioDetailsWSModel apiGetScenarioDetails(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioDetailsWSModel response = new ApiScenarioDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiScenarioDetailsWSDTO scenarioDetailsWSDTO = apiScenarioDetailsFramework.apiGetScenarioDetailsService(agentId,sessionId,clientId,processId);
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


    public ApiScenarioActionWSModel apiGetScenarioActions(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioActionWSModel response = new ApiScenarioActionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioActionWSDTO> scenarioActionWSDTOS = apiScenarioDetailsFramework.apiGetScenarioActionsService(agentId,sessionId,clientId,processId);
        if (scenarioActionWSDTOS != null){
            response.setScenarioActions(scenarioActionWSDTOS);
        }

        general.setOperation("apiGetActionElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioActionWSModel apiGetScenarioAction(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioActionWSModel response = new ApiScenarioActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioActionWSDTO>scenarioActionWSDTOS = new ArrayList<>();

        ApiScenarioActionWSDTO scenarioActionWSDTO = apiScenarioDetailsFramework.apiGetScenarioActionService(agentId,sessionId,clientId,processId);
        if (scenarioActionWSDTO != null){
            scenarioActionWSDTOS.add(scenarioActionWSDTO);
        }

        response.setScenarioActions(scenarioActionWSDTOS);
        general.setOperation("apiGetScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioAutomationWSModel apiGetScenarioAutomations(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioAutomationWSModel response = new ApiScenarioAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioAutomationWSDTO> scenarioAutomationWSDTOS = apiScenarioDetailsFramework.apiGetScenarioAutomationsService(agentId,sessionId,clientId,processId);
        if (scenarioAutomationWSDTOS != null){
            response.setScenarioAutomations(scenarioAutomationWSDTOS);
        }

        general.setOperation("apiGetScenarioAutomations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioAutomationWSModel apiGetScenarioAutomation(long agentId, long sessionId, long clientId, String processId) {

        ApiScenarioAutomationWSModel response = new ApiScenarioAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioAutomationWSDTO>scenarioAutomations = new ArrayList<>();

        ApiScenarioAutomationWSDTO scenarioAutomation = apiScenarioDetailsFramework.apiGetScenarioAutomationService(agentId,sessionId,clientId,processId);
        if (scenarioAutomation != null){
            scenarioAutomations.add(scenarioAutomation);
        }

        response.setScenarioAutomations(scenarioAutomations);
        general.setOperation("apiGetScenarioAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
