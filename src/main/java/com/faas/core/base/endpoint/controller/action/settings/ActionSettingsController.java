package com.faas.core.base.endpoint.controller.action.settings;

import com.faas.core.base.middleware.action.settings.ActionSettingsMiddleware;
import com.faas.core.base.model.ws.action.settings.ActionTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/action/settings/")
public class ActionSettingsController {

    @Autowired
    ActionSettingsMiddleware actionSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ACTION_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getActionTypes(@RequestParam long userId) {

        ActionTypeWSModel response = actionSettingsMiddleware.getActionTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getActionType(@RequestParam long userId,
                                           @RequestParam long typeId) {

        ActionTypeWSModel response = actionSettingsMiddleware.getActionType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createActionType(@RequestParam long userId,
                                              @RequestParam String actionType) {

        ActionTypeWSModel response = actionSettingsMiddleware.createActionType(userId,actionType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionType(@RequestParam long userId,
                                              @RequestParam long typeId,
                                              @RequestParam String actionType) {

        ActionTypeWSModel response = actionSettingsMiddleware.updateActionType(userId,typeId,actionType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionType(@RequestParam long userId,
                                              @RequestParam long typeId) {

        ActionTypeWSModel response = actionSettingsMiddleware.removeActionType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
