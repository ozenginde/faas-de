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


    public ApiScenarioExecuteWSModel apiGetScenarioExecutes(long agentId, long sessionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioExecuteWSDTO> scenarioExecuteWSDTOS =  apiScenarioExecuteFramework.apiGetScenarioExecutesService(agentId,sessionId);
        if (scenarioExecuteWSDTOS != null){
            response.setScenarioExecutes(scenarioExecuteWSDTOS);
        }

        general.setOperation("apiGetScenarioExecutes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecuteWSModel apiGetScenarioExecute(long agentId, long sessionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecuteWSDTO>scenarioExecuteWSDTOS = new ArrayList<>();

        ApiScenarioExecuteWSDTO scenarioExecuteWSDTO =  apiScenarioExecuteFramework.apiGetScenarioExecuteService(agentId,sessionId);
        if (scenarioExecuteWSDTO != null){
            scenarioExecuteWSDTOS.add(scenarioExecuteWSDTO);
        }

        response.setScenarioExecutes(scenarioExecuteWSDTOS);
        general.setOperation("apiGetScenarioExecute");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioExecuteWSModel apiExecuteScenario(long agentId, long sessionId) {

        ApiScenarioExecuteWSModel response = new ApiScenarioExecuteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioExecuteWSDTO>scenarioExecuteWSDTOS = new ArrayList<>();

        ApiScenarioExecuteWSDTO scenarioExecuteWSDTO =  apiScenarioExecuteFramework.apiExecuteScenarioService(agentId,sessionId);
        if (scenarioExecuteWSDTO != null){
            scenarioExecuteWSDTOS.add(scenarioExecuteWSDTO);
        }

        response.setScenarioExecutes(scenarioExecuteWSDTOS);
        general.setOperation("apiExecuteScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
