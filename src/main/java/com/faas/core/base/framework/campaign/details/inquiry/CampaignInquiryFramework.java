package com.faas.core.base.framework.campaign.details.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignInquiryFramework {


    @Autowired
    AppUtils appUtils;


    public CampaignClientWSDTO getCampaignInquiriesService(long userId, String city, String country, String inquiryState, int reqPage, int reqSize) {

        return null;
    }




}
