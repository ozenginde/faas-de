package com.faas.core.base.endpoint.controller.campaign.details.client.flow;

import com.faas.core.base.middleware.campaign.details.automatic.flow.CampaignFlowMiddleware;
import com.faas.core.base.model.ws.campaign.details.manual.client.CampaignClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/flow/")
public class CampaignFlowController {


    @Autowired
    CampaignFlowMiddleware campaignFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOWS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlows(@RequestParam long userId,
                                              @RequestParam String city,
                                              @RequestParam String country,
                                              @RequestParam String flowState,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignFlowMiddleware.getCampaignFlows(userId,city,country,flowState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
