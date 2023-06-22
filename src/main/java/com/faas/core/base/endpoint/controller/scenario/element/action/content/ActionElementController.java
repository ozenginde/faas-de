package com.faas.core.base.endpoint.controller.scenario.element.action.content;

import com.faas.core.base.middleware.scenario.element.action.content.ActionElementMiddleware;
import com.faas.core.base.model.ws.scenario.element.action.content.ActionElementWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/action/")
public class ActionElementController {


    @Autowired
    ActionElementMiddleware actionElementMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_ACTION_ELEMENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioActionElements(@RequestParam long userId,
                                                       @RequestParam String scenarioId) {

        ActionElementWSModel response = actionElementMiddleware.getScenarioActionElements(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> getActionElement(@RequestParam long userId,
                                              @RequestParam String elementId) {

        ActionElementWSModel response = actionElementMiddleware.getActionElement(userId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> createActionElement(@RequestParam long userId,
                                                 @RequestParam String scenarioId,
                                                 @RequestParam String actionName,
                                                 @RequestParam String actionDesc,
                                                 @RequestParam long actionTempId,
                                                 @RequestParam int order) {

        ActionElementWSModel response = actionElementMiddleware.createActionElement(userId,scenarioId,actionName,actionDesc,actionTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ACTION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionElement(@RequestParam long userId,
                                                 @RequestParam String elementId,
                                                 @RequestParam String actionName,
                                                 @RequestParam String actionDesc,
                                                 @RequestParam long actionTempId,
                                                 @RequestParam int order) {

        ActionElementWSModel response = actionElementMiddleware.updateActionElement(userId,elementId,actionName,actionDesc,actionTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_ELEMENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionElement(@RequestParam long userId,
                                                 @RequestParam String elementId) {

        ActionElementWSModel response = actionElementMiddleware.removeActionElement(userId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
