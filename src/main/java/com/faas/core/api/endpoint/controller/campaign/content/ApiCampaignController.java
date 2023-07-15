package com.faas.core.api.endpoint.controller.campaign.content;

import com.faas.core.api.middleware.campaign.content.ApiCampaignMiddleware;
import com.faas.core.api.model.ws.campaign.content.ApiAgentCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/campaign/")
public class ApiCampaignController {


    @Autowired
    ApiCampaignMiddleware apiCampaignMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaign(@RequestParam long agentId) {

        ApiAgentCampaignWSModel response = apiCampaignMiddleware.apiGetAgentCampaign(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaigns(@RequestParam long agentId,
                                             @RequestParam String category) {

        ApiCampaignWSModel response = apiCampaignMiddleware.apiGetCampaigns(agentId,category);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaign(@RequestParam long agentId,
                                            @RequestParam String campaignId) {

        ApiCampaignWSModel response = apiCampaignMiddleware.apiGetCampaign(agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AGENT_CAMPAIGN_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentCampaignSummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiCampaignMiddleware.apiGetAgentCampaignSummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
