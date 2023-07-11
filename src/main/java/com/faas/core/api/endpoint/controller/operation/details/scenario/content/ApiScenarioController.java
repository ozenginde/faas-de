package com.faas.core.api.endpoint.controller.operation.details.scenario.content;

import com.faas.core.api.middleware.operation.details.scenario.content.ApiScenarioMiddleware;
import com.faas.core.api.model.ws.operation.details.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.details.scenario.content.ApiScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/scenario/")
public class ApiScenarioController {


    @Autowired
    ApiScenarioMiddleware apiScenarioMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationScenario(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long clientId,
                                                     @RequestParam String processId) {

        ApiOperationScenarioWSModel response = apiScenarioMiddleware.apiGetOperationScenario(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarios(@RequestParam long agentId,
                                             @RequestParam long sessionId,
                                             @RequestParam long clientId,
                                             @RequestParam String processId) {

        ApiScenarioWSModel response = apiScenarioMiddleware.apiGetScenarios(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenario(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam long clientId,
                                            @RequestParam String processId,
                                            @RequestParam String scenarioId) {

        ApiScenarioWSModel response = apiScenarioMiddleware.apiGetScenario(agentId,sessionId,clientId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
