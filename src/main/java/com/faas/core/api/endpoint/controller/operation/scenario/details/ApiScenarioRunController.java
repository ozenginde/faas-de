package com.faas.core.api.endpoint.controller.operation.scenario.details;

import com.faas.core.api.middleware.operation.scenario.details.ApiScenarioRunMiddleware;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioExecutionWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/run/")
public class ApiScenarioRunController {


    @Autowired
    ApiScenarioRunMiddleware apiScenarioRunMiddleware;


    @RequestMapping(value = ApiRoute.API_EXECUTE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiExecuteScenario(@RequestParam long agentId,
                                                @RequestParam long sessionId,
                                                @RequestParam long clientId,
                                                @RequestParam String scenarioId) {

        ApiScenarioExecutionWSModel response = apiScenarioRunMiddleware.apiExecuteScenario(agentId,sessionId,clientId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
