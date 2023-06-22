package com.faas.core.base.endpoint.controller.inquiry.details;

import com.faas.core.base.middleware.inquiry.details.InquiryDetailsMiddleware;
import com.faas.core.base.model.ws.client.content.ClientsByStateWSModel;
import com.faas.core.base.model.ws.inquiry.details.InquiryDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/inquiry/details/")
public class InquiryDetailsController {


    @Autowired
    InquiryDetailsMiddleware inquiryDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_INQUIRY_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryDetails(@RequestParam long userId,
                                               @RequestParam long inquiryId) {

        InquiryDetailsWSModel response = inquiryDetailsMiddleware.getInquiryDetails(userId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
