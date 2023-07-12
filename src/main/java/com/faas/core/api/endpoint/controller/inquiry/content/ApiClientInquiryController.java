
package com.faas.core.api.endpoint.controller.inquiry.content;

import com.faas.core.api.middleware.inquiry.content.ApiClientInquiryMiddleware;
import com.faas.core.api.model.ws.inquiry.content.ApiAgentInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiClientInquiryWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/inquiry/")
public class ApiClientInquiryController {


    @Autowired
    ApiClientInquiryMiddleware apiClientInquiryMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentInquiry(@RequestParam long agentId) {

        ApiAgentInquiryWSModel response = apiClientInquiryMiddleware.apiGetAgentInquiry(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientInquiries(@RequestParam long agentId) {

        ApiClientInquiryWSModel response = apiClientInquiryMiddleware.apiGetClientInquiries(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_INQUIRIES_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientInquiriesByState(@RequestParam long agentId,
                                                          @RequestParam String inquiryState) {

        ApiClientInquiryWSModel response = apiClientInquiryMiddleware.apiGetClientInquiriesByState(agentId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientInquiry(@RequestParam long agentId,
                                                 @RequestParam long inquiryId) {

        ApiClientInquiryWSModel response = apiClientInquiryMiddleware.apiGetClientInquiry(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateClientInquiry(@RequestParam long agentId,
                                                    @RequestParam long inquiryId) {

        ApiClientInquiryWSModel response = apiClientInquiryMiddleware.apiUpdateClientInquiry(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_CLIENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveClientInquiry(@RequestParam long agentId,
                                                    @RequestParam long inquiryId) {

        ApiClientInquiryWSModel response = apiClientInquiryMiddleware.apiRemoveClientInquiry(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
