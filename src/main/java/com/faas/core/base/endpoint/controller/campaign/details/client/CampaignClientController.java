package com.faas.core.base.endpoint.controller.campaign.details.client;

import com.faas.core.base.middleware.campaign.details.client.CampaignClientMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/")
public class CampaignClientController {


    @Autowired
    CampaignClientMiddleware campaignClientMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignClients(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignClientMiddleware.getCampaignClients(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CLIENTS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignClientsByState(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String clientState,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignClientMiddleware.getCampaignClientsByState(userId,campaignId,clientState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignClient(@RequestParam long userId,
                                               @RequestParam long clientId) {

        CampaignClientWSModel response = campaignClientMiddleware.getCampaignClient(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
