package com.faas.core.api.endpoint.controller.operation.scenario.execute;

import com.faas.core.api.middleware.operation.scenario.execute.ApiScenarioExecuteMiddleware;
import com.faas.core.api.model.ws.operation.scenario.execute.ApiScenarioExecuteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/execute/")
public class ApiScenarioExecuteController {


    @Autowired
    ApiScenarioExecuteMiddleware apiScenarioExecuteMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_EXECUTES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioExecutes(@RequestParam long agentId,
                                                    @RequestParam long sessionId) {

        ApiScenarioExecuteWSModel response = apiScenarioExecuteMiddleware.apiGetScenarioExecutes(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_EXECUTE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioExecute(@RequestParam long agentId,
                                                   @RequestParam long sessionId) {

        ApiScenarioExecuteWSModel response = apiScenarioExecuteMiddleware.apiGetScenarioExecute(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_EXECUTE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiExecuteScenario(@RequestParam long agentId,
                                                @RequestParam long sessionId) {

        ApiScenarioExecuteWSModel response = apiScenarioExecuteMiddleware.apiExecuteScenario(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
