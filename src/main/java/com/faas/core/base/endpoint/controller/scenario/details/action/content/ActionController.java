package com.faas.core.base.endpoint.controller.scenario.details.action.content;

import com.faas.core.base.middleware.scenario.details.action.content.ActionMiddleware;
import com.faas.core.base.model.ws.scenario.details.action.content.ActionWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/details/action/")
public class ActionController {


    @Autowired
    ActionMiddleware actionMiddleware;


    @RequestMapping(value = BaseRoute.GET_SCENARIO_ACTIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getScenarioActions(@RequestParam long userId,
                                                @RequestParam String scenarioId) {

        ActionWSModel response = actionMiddleware.getScenarioActions(userId,scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> getAction(@RequestParam long userId,
                                       @RequestParam String actionId) {

        ActionWSModel response = actionMiddleware.getAction(userId,actionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> createAction(@RequestParam long userId,
                                          @RequestParam String scenarioId,
                                          @RequestParam String action,
                                          @RequestParam String actionDesc,
                                          @RequestParam long actionTempId,
                                          @RequestParam int order) {

        ActionWSModel response = actionMiddleware.createAction(userId,scenarioId,action,actionDesc,actionTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> updateAction(@RequestParam long userId,
                                          @RequestParam String actionId,
                                          @RequestParam String action,
                                          @RequestParam String actionDesc,
                                          @RequestParam long actionTempId,
                                          @RequestParam int order) {

        ActionWSModel response = actionMiddleware.updateAction(userId,actionId,action,actionDesc,actionTempId,order);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION, method = RequestMethod.POST)
    public ResponseEntity<?> removeAction(@RequestParam long userId,
                                          @RequestParam String actionId) {

        ActionWSModel response = actionMiddleware.removeAction(userId,actionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
