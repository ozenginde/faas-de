package com.faas.core.base.framework.flow.settings;

import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlowSettingsFramework {



    @Autowired
    AppUtils appUtils;



    public CampaignTypeDBModel getAllFlowTypesService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel getFlowTypeService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel createFlowTypeService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel updateFlowTypeService(long typeId) {

        return null;
    }


    public CampaignTypeDBModel removeFlowTypeService(long typeId) {

        return null;
    }



}
