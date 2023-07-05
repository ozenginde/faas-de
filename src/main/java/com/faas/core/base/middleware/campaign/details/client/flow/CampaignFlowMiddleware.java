package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowFramework;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowWSDTO;
import com.faas.core.base.model.ws.flow.content.FlowWSModel;
import com.faas.core.base.model.ws.flow.content.dto.FlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignFlowMiddleware {


    @Autowired
    CampaignFlowFramework campaignFlowFramework;


    public CampaignFlowWSModel searchCampaignFlows(long userId,String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignFlowWSModel response = new CampaignFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowWSDTO campaignFlowWSDTO = campaignFlowFramework.searchCampaignFlowsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignFlowWSDTO != null){
            response.setCampaignFlow(campaignFlowWSDTO);
        }

        general.setOperation("searchCampaignFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignFlowWSModel getCampaignFlows(long userId, String campaignId, int reqPage, int reqSize) {

        CampaignFlowWSModel response = new CampaignFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowWSDTO campaignFlowWSDTO = campaignFlowFramework.getCampaignFlowsService(userId,campaignId,reqPage,reqSize);
        if (campaignFlowWSDTO != null){
            response.setCampaignFlow(campaignFlowWSDTO);
        }

        general.setOperation("getCampaignFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getCampaignFlow(long userId,long flowId,long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = campaignFlowFramework.getCampaignFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel createCampaignFlow(long userId,String campaignId,long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = campaignFlowFramework.createCampaignFlowService(userId,campaignId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("createCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel updateCampaignFlow(long userId,long flowId,long clientId,String flowState) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = campaignFlowFramework.updateCampaignFlowService(userId,flowId,clientId,flowState);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("updateCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel removeCampaignFlow(long userId,long flowId,long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = campaignFlowFramework.removeCampaignFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("removeCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
