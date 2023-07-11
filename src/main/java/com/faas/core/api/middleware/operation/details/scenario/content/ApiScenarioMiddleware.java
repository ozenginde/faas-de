package com.faas.core.api.middleware.operation.details.scenario.content;

import com.faas.core.api.framework.operation.details.scenario.content.ApiScenarioFramework;
import com.faas.core.api.model.ws.operation.details.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.details.scenario.content.ApiScenarioWSModel;
import com.faas.core.api.model.ws.operation.details.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.content.dto.ApiScenarioWSDTO;
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


    public ApiScenarioWSModel apiGetScenarios(long agentId,long sessionId, String processId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioWSDTO> scenarioWSDTOS = apiScenarioFramework.apiGetScenariosService(agentId,sessionId,processId);
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


    public ApiScenarioWSModel apiGetScenario(long agentId,long sessionId,String processId,String scenarioId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

        ApiScenarioWSDTO scenarioWSDTO = apiScenarioFramework.apiGetScenarioService(agentId,sessionId,processId,scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("apiGetProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
