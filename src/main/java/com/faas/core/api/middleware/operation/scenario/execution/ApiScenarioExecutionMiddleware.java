package com.faas.core.api.middleware.operation.scenario.execution;

import com.faas.core.api.framework.operation.scenario.execution.ApiScenarioExecutionFramework;
import com.faas.core.api.model.ws.operation.scenario.execution.ApiExecutionWSModel;
import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiExecutionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiScenarioExecutionMiddleware {


    @Autowired
    ApiScenarioExecutionFramework apiScenarioExecutionFramework;


    public ApiExecutionWSModel apiGetScenarioExecutions(long agentId, long sessionId, long clientId, String scenarioId) {

        ApiExecutionWSModel response = new ApiExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiGetScenarioExecutions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiExecutionWSModel apiGetScenarioExecution(long agentId, long sessionId, String scenarioId) {

        ApiExecutionWSModel response = new ApiExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiExecutionWSModel apiExecuteScenario(long agentId, long sessionId, long clientId, String executionId) {

        ApiExecutionWSModel response = new ApiExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiExecutionWSDTO scenarioExecutionWSDTO =  apiScenarioExecutionFramework.apiGetScenarioExecutionService(agentId,sessionId,clientId,executionId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        general.setOperation("apiGetScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiExecutionWSModel apiUpdateScenarioExecution(long agentId, long sessionId, long clientId, String executionId) {

        ApiExecutionWSModel response = new ApiExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiUpdateScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiExecutionWSModel apiRemoveScenarioExecution(long agentId, long sessionId, long clientId, String executionId) {

        ApiExecutionWSModel response = new ApiExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiRemoveScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
