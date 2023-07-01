package com.faas.core.base.middleware.campaign.details.automatic.flow;

import com.faas.core.base.framework.campaign.details.automatic.CampaignFlowFramework;
import com.faas.core.base.model.ws.campaign.details.manual.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.manual.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignFlowMiddleware {


    @Autowired
    CampaignFlowFramework campaignFlowFramework;


    public CampaignClientWSModel getCampaignFlows(long userId,String city,String country,String flowState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.getCampaignFlowsService(userId,city,country,flowState,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
