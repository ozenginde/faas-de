package com.faas.core.api.middleware.operation.scenario.content;

import com.faas.core.api.framework.operation.scenario.content.ApiScenarioDetailsFramework;
import com.faas.core.api.model.ws.operation.scenario.content.ApiActionWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiAutomationWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiScenarioDetailsWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiActionWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiAutomationWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiScenarioDetailsWSDTO;
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


    public ApiScenarioDetailsWSModel apiGetScenarioDetails(long agentId,long sessionId,String scenarioId) {

        ApiScenarioDetailsWSModel response = new ApiScenarioDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiScenarioDetailsWSDTO scenarioDetailsWSDTO = apiScenarioDetailsFramework.apiGetScenarioDetailsService(agentId,sessionId,scenarioId);
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


    public ApiActionWSModel apiGetScenarioActions(long agentId, long sessionId,String scenarioId) {

        ApiActionWSModel response = new ApiActionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiActionWSDTO> scenarioActionWSDTOS = apiScenarioDetailsFramework.apiGetScenarioActionsService(agentId,sessionId,scenarioId);
        if (scenarioActionWSDTOS != null){
        }

        general.setOperation("apiGetActionElements");
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

        ApiActionWSDTO scenarioActionWSDTO = apiScenarioDetailsFramework.apiGetScenarioActionService(agentId,sessionId,processId);
        if (scenarioActionWSDTO != null){
            scenarioActionWSDTOS.add(scenarioActionWSDTO);
        }

        general.setOperation("apiGetScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAutomationWSModel apiGetScenarioAutomations(long agentId, long sessionId, String processId) {

        ApiAutomationWSModel response = new ApiAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiAutomationWSDTO> scenarioAutomationWSDTOS = apiScenarioDetailsFramework.apiGetScenarioAutomationsService(agentId,sessionId,processId);
        if (scenarioAutomationWSDTOS != null){

        }

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

        ApiAutomationWSDTO scenarioAutomation = apiScenarioDetailsFramework.apiGetScenarioAutomationService(agentId,sessionId,processId);
        if (scenarioAutomation != null){
            scenarioAutomations.add(scenarioAutomation);
        }

        general.setOperation("apiGetScenarioAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
