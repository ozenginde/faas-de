package com.faas.core.api.middleware.operation.scenario.details;

import com.faas.core.api.framework.operation.scenario.details.ApiScenarioDetailsFramework;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioElementWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioDetailsWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.dto.ApiScenarioElementWSDTO;
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



    public ApiScenarioElementWSModel apiGetScenarioElements(long agentId, long sessionId, String scenarioId) {

        ApiScenarioElementWSModel response = new ApiScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetScenarioElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioElementWSModel apiGetScenarioElement(long agentId, long sessionId, String processId) {

        ApiScenarioElementWSModel response = new ApiScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();



        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("apiGetScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
