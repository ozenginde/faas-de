package com.faas.core.base.endpoint.controller.scenario.element.action.details;

import com.faas.core.base.middleware.scenario.element.action.details.ActionElementDetailsMiddleware;
import com.faas.core.base.model.ws.scenario.element.action.details.ActionElementDataWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/scenario/element/action/details/")
public class ActionElementDetailsController {


    @Autowired
    ActionElementDetailsMiddleware actionElementDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ACTION_ELEMENT_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getActionElementDatas(@RequestParam long userId,
                                                   @RequestParam String elementId) {

        ActionElementDataWSModel response = actionElementDetailsMiddleware.getActionElementDatas(userId,elementId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ACTION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getActionElementData(@RequestParam long userId,
                                                  @RequestParam String elementId,
                                                  @RequestParam String dataId) {

        ActionElementDataWSModel response = actionElementDetailsMiddleware.getActionElementData(userId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_ACTION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createActionElementData(@RequestParam long userId,
                                                     @RequestParam String elementId,
                                                     @RequestParam long dataTypeId,
                                                     @RequestParam String value) {

        ActionElementDataWSModel response = actionElementDetailsMiddleware.createActionElementData(userId,elementId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.UPDATE_ACTION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateActionElementData(@RequestParam long userId,
                                                     @RequestParam String elementId,
                                                     @RequestParam String dataId,
                                                     @RequestParam long dataTypeId,
                                                     @RequestParam String value) {

        ActionElementDataWSModel response = actionElementDetailsMiddleware.updateActionElementData(userId,elementId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_ACTION_ELEMENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeActionElementData(@RequestParam long userId,
                                                     @RequestParam String elementId,
                                                     @RequestParam String dataId) {

        ActionElementDataWSModel response = actionElementDetailsMiddleware.removeActionElementData(userId,elementId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
