package com.faas.core.api.middleware.operation.scenario.content;

import com.faas.core.api.framework.operation.scenario.content.ApiScenarioFramework;
import com.faas.core.api.model.ws.operation.scenario.content.*;
import com.faas.core.api.model.ws.operation.scenario.content.dto.*;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiScenarioMiddleware {


    @Autowired
    ApiScenarioFramework apiScenarioFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId,long sessionId,long clientId,String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiScenarioFramework.apiGetOperationScenarioService(agentId,sessionId,clientId,processId);
        if (operationScenarioWSDTO != null){
            response.setOperationScenario(operationScenarioWSDTO);
        }

        general.setOperation("apiGetOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenarios(long agentId,long sessionId,long clientId, String processId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioWSDTO> scenarioWSDTOS = apiScenarioFramework.apiGetScenariosService(agentId,sessionId,clientId,processId);
        if (scenarioWSDTOS != null){
            response.setScenarios(scenarioWSDTOS);
        }

        general.setOperation("apiGetScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenario(long agentId,long sessionId,long clientId,String processId,String scenarioId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

        ApiScenarioWSDTO scenarioWSDTO = apiScenarioFramework.apiGetScenarioService(agentId,sessionId,clientId,processId,scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("apiGetScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiUpdateScenario(long agentId,long sessionId,long clientId,String processId,String scenarioId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

        ApiScenarioWSDTO scenarioWSDTO = apiScenarioFramework.apiUpdateScenarioService(agentId,sessionId,clientId,processId,scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("apiUpdateScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiRemoveScenario(long agentId,long sessionId,long clientId,String processId,String scenarioId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

        ApiScenarioWSDTO scenarioWSDTO = apiScenarioFramework.apiRemoveScenarioService(agentId,sessionId,clientId,processId,scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("apiRemoveScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioDetailsWSModel apiGetScenarioDetails(long agentId, long sessionId, String scenarioId) {

        ApiScenarioDetailsWSModel response = new ApiScenarioDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarioDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioActionWSModel apiGetScenarioActions(long agentId, long sessionId, String scenarioId) {

        ApiScenarioActionWSModel response = new ApiScenarioActionWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioActionWSModel apiGetScenarioAction(long agentId, long sessionId, String processId) {

        ApiScenarioActionWSModel response = new ApiScenarioActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioActionWSDTO>scenarioActionWSDTOS = new ArrayList<>();



        general.setOperation("apiGetScenarioAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioAutomationWSModel apiGetScenarioAutomations(long agentId, long sessionId, String processId) {

        ApiScenarioAutomationWSModel response = new ApiScenarioAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioAutomations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioAutomationWSModel apiGetScenarioAutomation(long agentId, long sessionId, String processId) {

        ApiScenarioAutomationWSModel response = new ApiScenarioAutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioAutomationWSDTO>scenarioAutomations = new ArrayList<>();



        general.setOperation("apiGetScenarioAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
