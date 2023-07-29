package com.faas.core.api.middleware.operation.scenario.details;

import com.faas.core.api.framework.operation.scenario.details.ApiScenarioRunFramework;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioExecutionWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioExecutionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiScenarioRunMiddleware {


    @Autowired
    ApiScenarioRunFramework apiScenarioRunFramework;


    public ApiScenarioExecutionWSModel apiExecuteScenario(long agentId, long sessionId,long clientId,String scenarioId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecutionWSDTO scenarioExecutionWSDTO =  apiScenarioRunFramework.apiExecuteScenarioService(agentId,sessionId,clientId,scenarioId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setScenarioExecutions(scenarioExecutionWSDTOS);
        general.setOperation("apiExecuteScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecutionWSModel apiGetScenarioExecutions(long agentId, long sessionId,long clientId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioExecutionWSDTO> scenarioExecutionWSDTOS =  apiScenarioRunFramework.apiGetScenarioExecutionsService(agentId,sessionId,clientId);
        if (scenarioExecutionWSDTOS != null){
            response.setScenarioExecutions(scenarioExecutionWSDTOS);
        }

        general.setOperation("apiGetScenarioExecutions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecutionWSModel apiGetScenarioExecution(long agentId, long sessionId,long clientId,String executionId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecutionWSDTO scenarioExecutionWSDTO =  apiScenarioRunFramework.apiGetScenarioExecutionService(agentId,sessionId,clientId,executionId);
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


    public ApiScenarioExecutionWSModel apiUpdateScenarioExecution(long agentId,long sessionId,long clientId,String executionId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecutionWSDTO scenarioExecutionWSDTO =  apiScenarioRunFramework.apiUpdateScenarioExecutionService(agentId,sessionId,clientId,executionId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setScenarioExecutions(scenarioExecutionWSDTOS);
        general.setOperation("apiUpdateScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecutionWSModel apiRemoveScenarioExecution(long agentId,long sessionId,long clientId,String executionId) {

        ApiScenarioExecutionWSModel response = new ApiScenarioExecutionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecutionWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiScenarioExecutionWSDTO scenarioExecutionWSDTO =  apiScenarioRunFramework.apiRemoveScenarioExecutionService(agentId,sessionId,clientId,executionId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setScenarioExecutions(scenarioExecutionWSDTOS);
        general.setOperation("apiRemoveScenarioExecution");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
