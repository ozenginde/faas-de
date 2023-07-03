package com.faas.core.base.endpoint.controller.campaign.details.client.inquiry;

import com.faas.core.base.middleware.campaign.details.client.inquiry.CampaignInquiryMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.content.CampaignClientWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/inquiry/")
public class CampaignInquiryController {


    @Autowired
    CampaignInquiryMiddleware campaignInquiryMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignInquiries(@RequestParam long userId,
                                                      @RequestParam String city,
                                                      @RequestParam String country,
                                                      @RequestParam String inquiryState,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.searchCampaignInquiries(userId,city,country,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiries(@RequestParam long userId,
                                                  @RequestParam String city,
                                                  @RequestParam String country,
                                                  @RequestParam String inquiryState,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.getCampaignInquiries(userId,city,country,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiry(@RequestParam long userId,
                                                  @RequestParam String city,
                                                  @RequestParam String country,
                                                  @RequestParam String inquiryState,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.getCampaignInquiry(userId,city,country,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignInquiry(@RequestParam long userId,
                                                @RequestParam String city,
                                                @RequestParam String country,
                                                @RequestParam String inquiryState,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.createCampaignInquiry(userId,city,country,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignInquiry(@RequestParam long userId,
                                                   @RequestParam String city,
                                                   @RequestParam String country,
                                                   @RequestParam String inquiryState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.updateCampaignInquiry(userId,city,country,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignInquiry(@RequestParam long userId,
                                                   @RequestParam String city,
                                                   @RequestParam String country,
                                                   @RequestParam String inquiryState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        CampaignClientWSModel response = campaignInquiryMiddleware.removeCampaignInquiry(userId,city,country,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
