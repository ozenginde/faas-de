package com.faas.core.base.framework.campaign.details.client.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.inquiry.content.InquiryRequest;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignInquiryFramework {


    @Autowired
    AppUtils appUtils;


    public CampaignClientWSDTO searchCampaignInquiriesService(long userId, String campaignId,String city,String country,int reqPage,int reqSize) {

        return null;
    }



    public CampaignClientWSDTO getCampaignInquiriesService(long userId,String campaignId,String inquiryState, int reqPage, int reqSize) {

        return null;
    }


    public CampaignClientWSDTO getCampaignInquiryService(long userId,long inquiryId,long clientId) {

        return null;
    }


    public CampaignClientWSDTO createCampaignInquiryService(InquiryRequest inquiryRequest) {

        return null;
    }


    public CampaignClientWSDTO updateCampaignInquiryService(long userId,long inquiryId,long clientId,String campaignId,String inquiryState) {

        return null;
    }


    public CampaignClientWSDTO removeCampaignInquiryService(long userId,long inquiryId,long clientId) {

        return null;
    }

}
