package com.faas.core.api.endpoint.controller.campaign.details.content;

import com.faas.core.api.middleware.campaign.details.content.ApiCampaignDetailsMiddleware;
import com.faas.core.api.model.ws.campaign.details.content.ApiCampaignDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/details/")
public class ApiCampaignDetailsController {


    @Autowired
    ApiCampaignDetailsMiddleware apiCampaignDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignDetails(@RequestParam long agentId,
                                                   @RequestParam String campaignId) {

        ApiCampaignDetailsWSModel response = apiCampaignDetailsMiddleware.apiGetCampaignDetails(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
