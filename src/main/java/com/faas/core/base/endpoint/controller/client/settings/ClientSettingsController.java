package com.faas.core.base.endpoint.controller.client.settings;

import com.faas.core.base.middleware.client.settings.ClientSettingsMiddleware;
import com.faas.core.base.model.ws.client.settings.ClientTypeWSModel;
import com.faas.core.base.model.ws.client.settings.FlowTypeWSModel;
import com.faas.core.base.model.ws.client.settings.InquiryTypeWSModel;
import com.faas.core.base.model.ws.client.settings.SessionTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/settings/")
public class ClientSettingsController {


    @Autowired
    ClientSettingsMiddleware clientSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENT_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClientTypes(@RequestParam long userId) {

        ClientTypeWSModel response = clientSettingsMiddleware.getAllClientTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientType(@RequestParam long userId,
                                           @RequestParam long typeId) {

        ClientTypeWSModel response = clientSettingsMiddleware.getClientType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createClientType(@RequestParam long userId,
                                              @RequestParam String clientType) {

        ClientTypeWSModel response = clientSettingsMiddleware.createClientType(userId,clientType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientType(@RequestParam long userId,
                                              @RequestParam long typeId,
                                              @RequestParam String clientType) {

        ClientTypeWSModel response = clientSettingsMiddleware.updateClientType(userId,typeId,clientType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientType(@RequestParam long userId,
                                              @RequestParam long typeId) {

        ClientTypeWSModel response = clientSettingsMiddleware.removeClientType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_SESSION_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSessionTypes(@RequestParam long userId) {

        SessionTypeWSModel response = clientSettingsMiddleware.getAllSessionTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_SESSION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getSessionType(@RequestParam long userId) {

        SessionTypeWSModel response = clientSettingsMiddleware.getSessionType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_SESSION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createSessionType(@RequestParam long userId) {

        SessionTypeWSModel response = clientSettingsMiddleware.createSessionType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_SESSION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateSessionType(@RequestParam long userId) {

        SessionTypeWSModel response = clientSettingsMiddleware.updateSessionType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_SESSION_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeSessionType(@RequestParam long userId) {

        SessionTypeWSModel response = clientSettingsMiddleware.removeSessionType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




    @RequestMapping(value = BaseRoute.GET_ALL_INQUIRY_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllInquiryTypes(@RequestParam long userId) {

        InquiryTypeWSModel response = clientSettingsMiddleware.getAllInquiryTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = clientSettingsMiddleware.getInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = clientSettingsMiddleware.createInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = clientSettingsMiddleware.updateInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = clientSettingsMiddleware.removeInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_FLOW_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllFlowTypes(@RequestParam long userId) {

        FlowTypeWSModel response = clientSettingsMiddleware.getAllFlowTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = clientSettingsMiddleware.getFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = clientSettingsMiddleware.createFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = clientSettingsMiddleware.updateFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeFlowType(@RequestParam long userId) {

        FlowTypeWSModel response = clientSettingsMiddleware.removeFlowType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
