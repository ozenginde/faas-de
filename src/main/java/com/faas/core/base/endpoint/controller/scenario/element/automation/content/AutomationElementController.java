package com.faas.core.base.endpoint.controller.scenario.element.automation.content;

import com.faas.core.base.middleware.scenario.element.automation.content.AutomationElementMiddleware;
import com.faas.core.base.model.ws.scenario.element.automation.content.AutomationElementWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/automation/")
public class AutomationElementController {


    @Autowired
    AutomationElementMiddleware automationElementMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_AUTOMATION_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioAutomationElements(@RequestParam long userId,
                                                           @RequestParam String scenarioId) {

        AutomationElementWSModel response = automationElementMiddleware.getScenarioAutomationElements(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationElement(@RequestParam long userId,
                                                  @RequestParam String elementId) {

        AutomationElementWSModel response = automationElementMiddleware.getAutomationElement(userId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationElement(@RequestParam long userId,
                                                     @RequestParam String scenarioId,
                                                     @RequestParam String automationName,
                                                     @RequestParam String automationDesc,
                                                     @RequestParam long automationTempId,
                                                     @RequestParam int order) {

        AutomationElementWSModel response = automationElementMiddleware.createAutomationElement(userId,scenarioId,automationName,automationDesc,automationTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationElement(@RequestParam long userId,
                                                     @RequestParam String elementId,
                                                     @RequestParam String automationName,
                                                     @RequestParam String automationDesc,
                                                     @RequestParam long automationTempId,
                                                     @RequestParam int order) {

        AutomationElementWSModel response = automationElementMiddleware.updateAutomationElement(userId,elementId,automationName,automationDesc,automationTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationElement(@RequestParam long userId,
                                                     @RequestParam String elementId) {

        AutomationElementWSModel response = automationElementMiddleware.removeAutomationElement(userId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
