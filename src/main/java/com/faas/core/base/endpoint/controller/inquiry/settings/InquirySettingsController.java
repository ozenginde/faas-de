package com.faas.core.base.endpoint.controller.inquiry.settings;

import com.faas.core.base.middleware.inquiry.settings.InquirySettingsMiddleware;
import com.faas.core.base.model.ws.inquiry.settings.InquiryTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/inquiry/settings/")
public class InquirySettingsController {


    @Autowired
    InquirySettingsMiddleware inquirySettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_INQUIRY_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllInquiryTypes(@RequestParam long userId) {

        InquiryTypeWSModel response = inquirySettingsMiddleware.getAllInquiryTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = inquirySettingsMiddleware.getInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = inquirySettingsMiddleware.createInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = inquirySettingsMiddleware.updateInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeInquiryType(@RequestParam long userId) {

        InquiryTypeWSModel response = inquirySettingsMiddleware.removeInquiryType(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
