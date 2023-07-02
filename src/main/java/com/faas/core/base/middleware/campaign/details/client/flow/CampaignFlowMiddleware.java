package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowFramework;
import com.faas.core.base.model.ws.campaign.details.client.content.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
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


    public CampaignClientWSModel getCampaignFlow(long userId,String city,String country,String flowState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel createCampaignFlow(long userId,String city,String country,String flowState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel updateCampaignFlow(long userId,String city,String country,String flowState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel removeCampaignFlow(long userId,String city,String country,String flowState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
