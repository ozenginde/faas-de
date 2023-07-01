package com.faas.core.base.middleware.campaign.details.inquiry.content;

import com.faas.core.base.framework.campaign.details.inquiry.CampaignInquiryFramework;
import com.faas.core.base.model.ws.campaign.details.manual.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.manual.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignInquiryMiddleware {


    @Autowired
    CampaignInquiryFramework campaignInquiryFramework;


    public CampaignClientWSModel getCampaignInquiries(long userId, String city, String country, String inquiryState, int reqPage, int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignInquiryFramework.getCampaignInquiriesService(userId,city,country,inquiryState,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
