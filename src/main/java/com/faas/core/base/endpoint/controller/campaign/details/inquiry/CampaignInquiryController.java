package com.faas.core.base.endpoint.controller.campaign.details.inquiry;

import com.faas.core.base.middleware.campaign.inquiry.CampaignInquiryMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.CampaignClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/inquiry/")
public class CampaignInquiryController {


    @Autowired
    CampaignInquiryMiddleware campaignInquiryMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchClients(@RequestParam long userId,
                                           @RequestParam String city,
                                           @RequestParam String country,
                                           @RequestParam String clientState,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.searchClients(userId,city,country,clientState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
