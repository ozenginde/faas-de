package com.faas.core.api.middleware.campaign.details.content;

import com.faas.core.api.framework.campaign.details.content.ApiCampaignDetailsFramework;
import com.faas.core.api.model.ws.campaign.details.content.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.content.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignDetailsMiddleware {


    @Autowired
    ApiCampaignDetailsFramework apiCampaignDetailsFramework;


    public ApiCampaignDetailsWSModel apiGetCampaignDetails(long agentId, String campaignId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignDetailsWSDTO> apiCampaignDetailsWSDTOS = new ArrayList<>();


        response.setCampaignDetails(apiCampaignDetailsWSDTOS);
        general.setOperation("getAgentCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
