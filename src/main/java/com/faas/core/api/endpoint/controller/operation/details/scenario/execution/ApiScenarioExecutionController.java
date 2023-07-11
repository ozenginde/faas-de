package com.faas.core.api.endpoint.controller.operation.details.scenario.execution;

import com.faas.core.api.middleware.operation.details.scenario.execution.ApiScenarioExecutionMiddleware;
import com.faas.core.api.model.ws.operation.details.scenario.execution.ApiScenarioExecutionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/scenario/execution/")
public class ApiScenarioExecutionController {


    @Autowired
    ApiScenarioExecutionMiddleware apiScenarioExecutionMiddleware;


    @RequestMapping(value = ApiRoute.API_EXECUTE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiExecuteScenario(@RequestParam long agentId,
                                                @RequestParam long sessionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiExecuteScenario(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_EXECUTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioExecutions(@RequestParam long agentId,
                                                    @RequestParam long sessionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiGetScenarioExecutions(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_EXECUTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioExecution(@RequestParam long agentId,
                                                   @RequestParam long sessionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiGetScenarioExecution(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SCENARIO_EXECUTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateScenarioExecution(@RequestParam long agentId,
                                                     @RequestParam long sessionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiUpdateScenarioExecution(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SCENARIO_EXECUTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveScenarioExecution(@RequestParam long agentId,
                                                        @RequestParam long sessionId) {

        ApiScenarioExecutionWSModel response = apiScenarioExecutionMiddleware.apiRemoveScenarioExecution(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}