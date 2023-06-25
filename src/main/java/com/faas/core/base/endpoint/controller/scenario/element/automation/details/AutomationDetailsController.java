package com.faas.core.base.endpoint.controller.scenario.element.automation.details;

import com.faas.core.base.middleware.scenario.element.automation.details.AutomationDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.element.automation.details.AutomationVariableWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/automation/details/")
public class AutomationDetailsController {


    @Autowired
    AutomationDetailsMiddleware automationDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_VARIABLES, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationVariables(@RequestParam long userId,
                                                    @RequestParam String automationId) {

        AutomationVariableWSModel response = automationDetailsMiddleware.getAutomationVariables(userId,automationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomationVariable(@RequestParam long userId,
                                                   @RequestParam String automationId,
                                                   @RequestParam String variableId) {

        AutomationVariableWSModel response = automationDetailsMiddleware.getAutomationVariable(userId,automationId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_AUTOMATION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> createAutomationVariable(@RequestParam long userId,
                                                      @RequestParam String automationId,
                                                      @RequestParam long typeId,
                                                      @RequestParam String value) {

        AutomationVariableWSModel response = automationDetailsMiddleware.createAutomationVariable(userId,automationId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_AUTOMATION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> updateAutomationVariable(@RequestParam long userId,
                                                      @RequestParam String automationId,
                                                      @RequestParam String variableId,
                                                      @RequestParam long typeId,
                                                      @RequestParam String value) {

        AutomationVariableWSModel response = automationDetailsMiddleware.updateAutomationVariable(userId,automationId,variableId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_AUTOMATION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> removeAutomationVariable(@RequestParam long userId,
                                                      @RequestParam String automationId,
                                                      @RequestParam String variableId) {

        AutomationVariableWSModel response = automationDetailsMiddleware.removeAutomationVariable(userId,automationId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
