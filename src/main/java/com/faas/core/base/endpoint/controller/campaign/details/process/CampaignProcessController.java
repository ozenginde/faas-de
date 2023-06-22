package com.faas.core.base.endpoint.controller.campaign.details.process;

import com.faas.core.base.middleware.campaign.details.process.CampaignProcessMiddleware;
import com.faas.core.base.model.ws.campaign.details.process.CampaignProcessWSModel;
import com.faas.core.base.model.ws.process.content.ProcessWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/process/")
public class CampaignProcessController {


    @Autowired
    CampaignProcessMiddleware campaignProcessMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignProcess(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignProcessWSModel response = campaignProcessMiddleware.getCampaignProcess(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignProcess(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String processId) {

        CampaignProcessWSModel response = campaignProcessMiddleware.updateCampaignProcess(userId, campaignId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignProcess(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String processId) {

        CampaignProcessWSModel response = campaignProcessMiddleware.removeCampaignProcess(userId, campaignId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_ASSIGNABLE_PROCESSES, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignAssignableProcesses(@RequestParam long userId,
                                                            @RequestParam String campaignId) {

        ProcessWSModel response = campaignProcessMiddleware.getCampaignAssignableProcesses(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
