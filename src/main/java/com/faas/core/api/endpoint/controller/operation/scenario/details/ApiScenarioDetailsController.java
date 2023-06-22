package com.faas.core.api.endpoint.controller.operation.scenario.details;

import com.faas.core.api.middleware.operation.scenario.details.ApiScenarioDetailsMiddleware;
import com.faas.core.api.model.ws.operation.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.details.ApiScenarioElementWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/scenario/element/")
public class ApiScenarioDetailsController {


    @Autowired
    ApiScenarioDetailsMiddleware apiScenarioDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_SCENARIO_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetScenarioElements(@RequestParam long agentId,
                                                  @RequestParam long sessionId,
                                                  @RequestParam long clientId,
                                                  @RequestParam String processId) {

        ApiScenarioElementWSModel response = apiScenarioDetailsMiddleware.apiGetScenarioElements(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_ACTION_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetActionElements(@RequestParam long agentId,
                                                          @RequestParam long sessionId,
                                                          @RequestParam long clientId,
                                                          @RequestParam String processId) {

        ApiOperationScenarioWSModel response = apiScenarioDetailsMiddleware.apiGetActionElements(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_ACTION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetActionElement(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String processId) {

        ApiScenarioWSModel response = apiScenarioDetailsMiddleware.apiGetActionElement(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_AUTOMATION_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAutomationElements(@RequestParam long agentId,
                                                              @RequestParam long sessionId,
                                                              @RequestParam long clientId,
                                                              @RequestParam String processId) {

        ApiOperationScenarioWSModel response = apiScenarioDetailsMiddleware.apiGetAutomationElements(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AUTOMATION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAutomationElement(@RequestParam long agentId,
                                                     @RequestParam long sessionId,
                                                     @RequestParam long clientId,
                                                     @RequestParam String processId) {

        ApiScenarioWSModel response = apiScenarioDetailsMiddleware.apiGetAutomationElement(agentId,sessionId,clientId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
