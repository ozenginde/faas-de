package com.faas.core.base.framework.campaign.details.flow;

import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignFlowFramework {


    @Autowired
    AppUtils appUtils;


    public CampaignClientWSDTO getCampaignFlowsService(long userId,String city,String country,String flowState,int reqPage,int reqSize) {

        return null;
    }





}
