package com.faas.core.api.endpoint.controller.operation.scenario.content;

import com.faas.core.api.middleware.operation.scenario.content.ApiScenarioMiddleware;
import com.faas.core.api.model.ws.operation.scenario.content.*;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/")
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
                                             @RequestParam String processId) {

        ApiScenarioWSModel response = apiScenarioMiddleware.apiGetScenarios(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenario(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam String processId,
                                            @RequestParam String scenarioId) {

        ApiScenarioWSModel response = apiScenarioMiddleware.apiGetScenario(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateScenario(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam String processId,
                                               @RequestParam String scenarioId) {

        ApiScenarioWSModel response = apiScenarioMiddleware.apiUpdateScenario(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveScenario(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam String processId,
                                               @RequestParam String scenarioId) {

        ApiScenarioWSModel response = apiScenarioMiddleware.apiRemoveScenario(agentId,sessionId,clientId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioDetails(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String processId,
                                                   @RequestParam String scenarioId) {

        ApiScenarioDetailsWSModel response = apiScenarioMiddleware.apiGetScenarioDetails(agentId,sessionId,processId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ACTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioActions(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String scenarioId) {

        ApiActionWSModel response = apiScenarioMiddleware.apiGetScenarioActions(agentId,sessionId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAction(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam String processId) {

        ApiActionWSModel response = apiScenarioMiddleware.apiGetScenarioAction(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_AUTOMATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAutomations(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam String processId) {

        ApiAutomationWSModel response = apiScenarioMiddleware.apiGetScenarioAutomations(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAutomation(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam String processId) {

        ApiAutomationWSModel response = apiScenarioMiddleware.apiGetScenarioAutomation(agentId,sessionId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
