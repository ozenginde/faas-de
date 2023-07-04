package com.faas.core.base.framework.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.flow.content.FlowRequest;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignFlowFramework {


    @Autowired
    AppUtils appUtils;



    public CampaignClientWSDTO searchCampaignFlowsService(long userId,String campaignId,String city,String country,int reqPage,int reqSize) {

        return null;
    }


    public CampaignClientWSDTO getCampaignFlowsService(long userId,String campaignId,String flowState,int reqPage,int reqSize) {

        return null;
    }

    public CampaignClientWSDTO getCampaignFlowService(long userId,long flowId,long clientId) {

        return null;
    }


    public CampaignClientWSDTO createCampaignFlowService(FlowRequest flowRequest) {

        return null;
    }


    public CampaignClientWSDTO updateCampaignFlowService(long userId,long flowId,long clientId,String campaignId,String flowState) {

        return null;
    }


    public CampaignClientWSDTO removeCampaignFlowService(long userId,long flowId,long clientId) {

        return null;
    }


}
