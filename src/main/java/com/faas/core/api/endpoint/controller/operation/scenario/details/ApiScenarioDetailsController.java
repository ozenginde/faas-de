package com.faas.core.api.endpoint.controller.operation.scenario.details;

import com.faas.core.api.middleware.operation.scenario.details.ApiScenarioDetailsMiddleware;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioActionWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioAutomationWSModel;
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
                                                   @RequestParam long clientId,
                                                   @RequestParam String processId) {

        ApiScenarioDetailsWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioDetails(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ACTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioActions(@RequestParam long agentId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long clientId,
                                                   @RequestParam String processId) {

        ApiScenarioActionWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioActions(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAction(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam long clientId,
                                                  @RequestParam String processId) {

        ApiScenarioActionWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioAction(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_AUTOMATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAutomations(@RequestParam long agentId,
                                                       @RequestParam long sessionId,
                                                       @RequestParam long clientId,
                                                       @RequestParam String processId) {

        ApiScenarioAutomationWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioAutomations(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioAutomation(@RequestParam long agentId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam long clientId,
                                                      @RequestParam String processId) {

        ApiScenarioAutomationWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioAutomation(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
