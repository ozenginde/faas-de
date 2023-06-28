package com.faas.core.base.endpoint.controller.flow.settings;

import com.faas.core.base.middleware.flow.settings.FlowSettingsMiddleware;
import com.faas.core.base.model.ws.flow.settings.FlowTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/flow/settings/")
public class FlowSettingsController {


    @Autowired
    FlowSettingsMiddleware flowSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_FLOW_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllFlowTypes(@RequestParam long userId) {

        FlowTypeWSModel response = flowSettingsMiddleware.getAllFlowTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = flowSettingsMiddleware.getFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = flowSettingsMiddleware.createFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = flowSettingsMiddleware.updateFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = flowSettingsMiddleware.removeFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
