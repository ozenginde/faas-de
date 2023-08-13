package com.faas.core.api.middleware.operation.scenario.execution;

import com.faas.core.api.framework.operation.scenario.execution.ApiScenarioExecutionFramework;
import com.faas.core.api.model.ws.operation.scenario.execution.ApiScenarioExecutionWSModel;
import com.faas.core.api.model.ws.operation.scenario.execution.dto.ApiScenarioExecutionWSDTO;
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


    public ApiScenarioExecutionWSModel apiScenarioExecute(long agentId,long sessionId,String processId,String scenarioId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecutionWSDTO scenarioExecutionWSDTO =  apiScenarioExecutionFramework.apiScenarioExecuteService(agentId,sessionId,processId,scenarioId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setScenarioExecutions(scenarioExecutionWSDTOS);
        general.setOperation("apiGetScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecutionWSModel apiGetScenarioExecutions(long agentId, long sessionId, long clientId, String scenarioId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiGetScenarioExecutions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecutionWSModel apiGetScenarioExecution(long agentId, long sessionId, String scenarioId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ApiScenarioExecutionWSModel apiUpdateScenarioExecution(long agentId, long sessionId, long clientId, String executionId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiUpdateScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecutionWSModel apiRemoveScenarioExecution(long agentId, long sessionId, long clientId, String executionId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiRemoveScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
