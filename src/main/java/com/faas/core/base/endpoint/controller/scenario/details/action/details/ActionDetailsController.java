package com.faas.core.base.endpoint.controller.scenario.details.action.details;

import com.faas.core.base.middleware.scenario.details.action.details.ActionDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.details.action.details.ActionDataWSModel;
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

    
    @RequestMapping(value = BaseRoute.GET_ACTION_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getActionDatas(@RequestParam long userId,
                                            @RequestParam String actionId) {

        ActionDataWSModel response = actionDetailsMiddleware.getActionDatas(userId,actionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getActionData(@RequestParam long userId,
                                           @RequestParam String actionId,
                                           @RequestParam String dataId) {

        ActionDataWSModel response = actionDetailsMiddleware.getActionData(userId,actionId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createActionData(@RequestParam long userId,
                                              @RequestParam String actionId,
                                              @RequestParam long dataTypeId,
                                              @RequestParam String value) {

        ActionDataWSModel response = actionDetailsMiddleware.createActionData(userId,actionId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.UPDATE_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionData(@RequestParam long userId,
                                              @RequestParam String actionId,
                                              @RequestParam String dataId,
                                              @RequestParam long dataTypeId,
                                              @RequestParam String value) {

        ActionDataWSModel response = actionDetailsMiddleware.updateActionData(userId,actionId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionData(@RequestParam long userId,
                                              @RequestParam String actionId,
                                              @RequestParam String dataId) {

        ActionDataWSModel response = actionDetailsMiddleware.removeActionData(userId,actionId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
