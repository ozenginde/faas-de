package com.faas.core.base.endpoint.controller.scenario.details.automation.content;

import com.faas.core.base.middleware.scenario.details.automation.content.AutomationMiddleware;
import com.faas.core.base.model.ws.scenario.details.automation.content.AutomationWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/details/automation/")
public class AutomationController {


    @Autowired
    AutomationMiddleware automationMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_AUTOMATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioAutomations(@RequestParam long userId,
                                                    @RequestParam String scenarioId) {

        AutomationWSModel response = automationMiddleware.getScenarioAutomations(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomation(@RequestParam long userId,
                                           @RequestParam String automationId) {

        AutomationWSModel response = automationMiddleware.getAutomation(userId,automationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomation(@RequestParam long userId,
                                              @RequestParam String scenarioId,
                                              @RequestParam String automation,
                                              @RequestParam String automationDesc,
                                              @RequestParam long automationTempId,
                                              @RequestParam int order) {

        AutomationWSModel response = automationMiddleware.createAutomation(userId,scenarioId,automation,automationDesc,automationTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomation(@RequestParam long userId,
                                              @RequestParam String automationId,
                                              @RequestParam String automation,
                                              @RequestParam String automationDesc,
                                              @RequestParam long automationTempId,
                                              @RequestParam int order) {

        AutomationWSModel response = automationMiddleware.updateAutomation(userId,automationId,automation,automationDesc,automationTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomation(@RequestParam long userId,
                                              @RequestParam String automationId) {

        AutomationWSModel response = automationMiddleware.removeAutomation(userId,automationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
