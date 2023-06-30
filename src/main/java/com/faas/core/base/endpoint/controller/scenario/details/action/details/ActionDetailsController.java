package com.faas.core.base.endpoint.controller.scenario.details.action.details;

import com.faas.core.base.middleware.scenario.details.action.details.ActionDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.details.action.details.ActionVariableWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/details/action/details/")
public class ActionDetailsController {


    @Autowired
    ActionDetailsMiddleware actionDetailsMiddleware;

    
    @RequestMapping(value = BaseRoute.GET_ACTION_VARIABLES, method = RequestMethod.POST)
    public ResponseEntity<?> getActionVariables(@RequestParam long userId,
                                                @RequestParam String actionId) {

        ActionVariableWSModel response = actionDetailsMiddleware.getActionVariables(userId,actionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> getActionVariable(@RequestParam long userId,
                                               @RequestParam String actionId,
                                               @RequestParam String variableId) {

        ActionVariableWSModel response = actionDetailsMiddleware.getActionVariable(userId,actionId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> createActionVariable(@RequestParam long userId,
                                                  @RequestParam String actionId,
                                                  @RequestParam long typeId,
                                                  @RequestParam String value) {

        ActionVariableWSModel response = actionDetailsMiddleware.createActionVariable(userId,actionId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.UPDATE_ACTION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionVariable(@RequestParam long userId,
                                                  @RequestParam String actionId,
                                                  @RequestParam String variableId,
                                                  @RequestParam long typeId,
                                                  @RequestParam String value) {

        ActionVariableWSModel response = actionDetailsMiddleware.updateActionVariable(userId,actionId,variableId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_VARIABLE, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionVariable(@RequestParam long userId,
                                                  @RequestParam String actionId,
                                                  @RequestParam String variableId) {

        ActionVariableWSModel response = actionDetailsMiddleware.removeActionVariable(userId,actionId,variableId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
