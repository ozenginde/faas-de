package com.faas.core.base.middleware.campaign.details.client.flow;

import com.faas.core.base.framework.campaign.details.client.flow.CampaignFlowFramework;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowWSModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowWSDTO;
import com.faas.core.base.model.ws.flow.ClientFlowWSModel;
import com.faas.core.base.model.ws.flow.dto.ClientFlowWSDTO;
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


    public ClientFlowWSModel getCampaignFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowFramework.getCampaignFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel createCampaignFlow(long userId, String campaignId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowFramework.createCampaignFlowService(userId,campaignId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("createCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel updateCampaignFlow(long userId, long flowId, long clientId, String flowState) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowFramework.updateCampaignFlowService(userId,flowId,clientId,flowState);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("updateCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel removeCampaignFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = campaignFlowFramework.removeCampaignFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("removeCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
