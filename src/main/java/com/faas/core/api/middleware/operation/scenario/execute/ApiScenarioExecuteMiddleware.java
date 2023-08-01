package com.faas.core.api.middleware.operation.scenario.execute;

import com.faas.core.api.framework.operation.scenario.execute.ApiScenarioExecuteFramework;
import com.faas.core.api.model.ws.operation.scenario.execute.ApiScenarioExecuteWSModel;
import com.faas.core.api.model.ws.operation.scenario.execute.dto.ApiScenarioExecuteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiScenarioExecuteMiddleware {


    @Autowired
    ApiScenarioExecuteFramework apiScenarioExecuteFramework;


    public ApiScenarioExecuteWSModel apiGetScenarioExecutes(long agentId, long sessionId, long clientId, String scenarioId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecuteWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiExecuteScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecuteWSModel apiGetScenarioExecute(long agentId, long sessionId,String scenarioId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetScenarioExecutions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecuteWSModel apiExecuteScenario(long agentId, long sessionId, long clientId, String executionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecuteWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecuteWSDTO scenarioExecutionWSDTO =  apiScenarioExecuteFramework.apiGetScenarioExecutionService(agentId,sessionId,clientId,executionId);
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


    public ApiScenarioExecuteWSModel apiUpdateScenarioExecute(long agentId, long sessionId, long clientId, String executionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecuteWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecuteWSDTO scenarioExecutionWSDTO =  apiScenarioExecuteFramework.apiUpdateScenarioExecutionService(agentId,sessionId,clientId,executionId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        general.setOperation("apiUpdateScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecuteWSModel apiRemoveScenarioExecute(long agentId, long sessionId, long clientId, String executionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecuteWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();



        general.setOperation("apiRemoveScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
