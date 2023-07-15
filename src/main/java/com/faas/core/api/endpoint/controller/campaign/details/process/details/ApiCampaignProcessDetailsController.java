package com.faas.core.api.endpoint.controller.campaign.details.process.details;

import com.faas.core.api.model.ws.campaign.details.process.details.ApiProcessDetailsWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.api.middleware.campaign.details.process.details.ApiCampaignProcessDetailsMiddleware;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/process/details/")
public class ApiCampaignProcessDetailsController {


    @Autowired
    ApiCampaignProcessDetailsMiddleware apiCampaignProcessDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_PROCESS_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignProcessDetails(@RequestParam long agentId,
                                                          @RequestParam String campaignId,
                                                          @RequestParam String processId) {

        ApiProcessDetailsWSModel response = apiCampaignProcessDetailsMiddleware.apiGetCampaignProcessDetails(agentId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
