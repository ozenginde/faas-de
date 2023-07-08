package com.faas.core.base.endpoint.controller.inquiry;

import com.faas.core.base.middleware.inquiry.ClientInquiryMiddleware;
import com.faas.core.base.model.ws.inquiry.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.inquiry.ClientInquiryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/inquiry/")
public class ClientInquiryController {


    @Autowired
    ClientInquiryMiddleware clientInquiryMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENT_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClientInquiries(@RequestParam long userId,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ClientInquiryWSModel response = clientInquiryMiddleware.getAllClientInquiries(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_INQUIRIES_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientInquiriesByState(@RequestParam long userId,
                                                       @RequestParam String inquiryState,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        ClientInquiryWSModel response = clientInquiryMiddleware.getClientInquiriesByState(userId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaigns(@RequestParam long userId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        InquiryCampaignWSModel response = clientInquiryMiddleware.getInquiryCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaign(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        InquiryCampaignWSModel response = clientInquiryMiddleware.getInquiryCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getClientInquiry(@RequestParam long userId,
                                              @RequestParam long inquiryId,
                                              @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.getClientInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> createClientInquiry(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.createClientInquiry(userId,campaignId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientInquiry(@RequestParam long userId,
                                                 @RequestParam long inquiryId,
                                                 @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.updateClientInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientInquiry(@RequestParam long userId,
                                                 @RequestParam long inquiryId,
                                                 @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.removeClientInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
