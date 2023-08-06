package com.faas.core.api.endpoint.controller.operation.scenario.details;

import com.faas.core.api.middleware.operation.scenario.details.ApiScenarioDetailsMiddleware;
import com.faas.core.api.model.ws.operation.scenario.details.ApiActionWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiAutomationWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/details/")
public class ApiScenarioDetailsController {


    @Autowired
    ApiScenarioDetailsMiddleware apiScenarioDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioDetails(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId) {

        ApiScenarioDetailsWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioDetails(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ACTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioActions(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String scenarioId) {

        ApiActionWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioActions(agentId,sessionId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAction(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam String processId) {

        ApiActionWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioAction(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_AUTOMATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAutomations(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam String processId) {

        ApiAutomationWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioAutomations(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAutomation(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam String processId) {

        ApiAutomationWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioAutomation(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
