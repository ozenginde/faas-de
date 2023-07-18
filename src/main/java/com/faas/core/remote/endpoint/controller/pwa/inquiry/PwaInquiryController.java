package com.faas.core.remote.endpoint.controller.pwa.inquiry;

import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.remote.service.pwa.inquiry.PwaInquiryService;
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
@RequestMapping(value = AppConstant.API_VERSION + "/remote/pwa/inquiry/")
public class PwaInquiryController {


    @Autowired
    PwaInquiryService pwaInquiryService;


    @RequestMapping(value = ApiRoute.API_AGENT_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> apiAgentLogin(@RequestParam long agentId) {

        ApiAgentWSModel response = pwaInquiryService.apiAgentLogin(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }





}
