package com.faas.core.base.endpoint.controller.campaign.details.session;

import com.faas.core.base.middleware.campaign.details.session.CampaignSessionMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.session.CampaignSessionWSModel;
import com.faas.core.base.model.ws.client.content.CreateClientRequestModel;
import com.faas.core.base.model.ws.session.content.CreateSessionRequestModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/session/")
public class CampaignSessionController {


    @Autowired
    CampaignSessionMiddleware campaignSessionMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSessions(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        CampaignSessionWSModel response = campaignSessionMiddleware.getCampaignSessions(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SESSIONS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSessionsByState(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String sessionState,
                                                        @RequestParam int reqPage,
                                                        @RequestParam int reqSize) {

        CampaignSessionWSModel response = campaignSessionMiddleware.getCampaignSessionsByState(userId,campaignId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignSession(@RequestParam long userId,
                                                @RequestParam long sessionId,
                                                @RequestParam String campaignId) {

        CampaignSessionWSModel response = campaignSessionMiddleware.getCampaignSession(userId,sessionId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSession(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam long clientId,
                                                   @RequestParam long agentId) {

        CampaignSessionWSModel response = campaignSessionMiddleware.createCampaignSession(userId,campaignId,clientId,agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignSessions(@RequestBody CreateSessionRequestModel sessionRequest) {

        CampaignSessionWSModel response = campaignSessionMiddleware.createCampaignSessions(sessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignSession(@RequestParam long userId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam long agentId,
                                                   @RequestParam String processId,
                                                   @RequestParam String sessionState) {

        CampaignSessionWSModel response = campaignSessionMiddleware.updateCampaignSession(userId,sessionId,agentId,processId,sessionState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignSession(@RequestParam long userId,
                                                   @RequestParam long sessionId,
                                                   @RequestParam String campaignId) {

        CampaignSessionWSModel response = campaignSessionMiddleware.removeCampaignSession(userId,sessionId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignClients(@RequestParam long userId,
                                                   @RequestParam String cityQuery,
                                                   @RequestParam String countryQuery,
                                                   @RequestParam String clientState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignSessionMiddleware.searchCampaignClients(userId,cityQuery,countryQuery,clientState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
