package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowFramework;
import com.faas.core.base.model.ws.campaign.details.client.content.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.flow.content.FlowRequest;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignFlowMiddleware {


    @Autowired
    CampaignFlowFramework campaignFlowFramework;


    public CampaignClientWSModel searchCampaignFlows(long userId,String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.searchCampaignFlowsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("searchCampaignFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel getCampaignFlows(long userId,String campaignId,String flowState,int reqPage,int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.getCampaignFlowsService(userId,campaignId,flowState,reqPage,reqSize);
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


    public CampaignClientWSModel getCampaignFlow(long userId,long flowId,long clientId) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.getCampaignFlowService(userId,flowId,clientId);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignClientWSModel createCampaignFlow(FlowRequest flowRequest) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.createCampaignFlowService(flowRequest);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("createCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel updateCampaignFlow(long userId,long flowId,long clientId,String campaignId,String flowState) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.updateCampaignFlowService(userId,flowId,clientId,campaignId,flowState);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("updateCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel removeCampaignFlow(long userId,long flowId,long clientId) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignFlowFramework.removeCampaignFlowService(userId,flowId,clientId);
        if (campaignClientWSDTO != null){
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("removeCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
