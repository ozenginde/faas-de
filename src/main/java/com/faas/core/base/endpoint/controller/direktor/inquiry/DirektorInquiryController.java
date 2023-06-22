package com.faas.core.base.endpoint.controller.direktor.inquiry;

import com.faas.core.base.middleware.direktor.inquiry.DirektorInquiryMiddleware;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/direktor/inquiry/")
public class DirektorInquiryController {


    @Autowired
    DirektorInquiryMiddleware direktorInquiryMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClients(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        AllClientsWSModel response = direktorInquiryMiddleware.getAllClients(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
