package com.faas.core.base.middleware.dashboard.campaign;

import com.faas.core.base.framework.dashboard.campaign.DashboardCampaignFramework;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
import com.faas.core.base.model.ws.dashboard.campaign.DashboardCampaignWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashboardCampaignMiddleware {


    @Autowired
    DashboardCampaignFramework dashboardCampaignFramework;


    public DashboardCampaignWSModel getDashboardCampaigns(long userId, int reqPage, int reqSize) {

        DashboardCampaignWSModel response = new DashboardCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getDashboardCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
