package com.faas.core.base.middleware.flow;

import com.faas.core.base.framework.flow.ClientFlowFramework;
import com.faas.core.base.model.ws.flow.FlowCampaignWSModel;
import com.faas.core.base.model.ws.flow.ClientFlowWSModel;
import com.faas.core.base.model.ws.flow.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientFlowMiddleware {


    @Autowired
    ClientFlowFramework clientFlowFramework;


    public ClientFlowWSModel getAllClientFlows(long userId, int reqPage, int reqSize) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientFlowWSDTO> clientFlowWSDTOS = clientFlowFramework.getAllClientFlowsService(userId,reqPage,reqSize);
        if (clientFlowWSDTOS != null){
            response.setClientFlows(clientFlowWSDTOS);
        }

        general.setOperation("getAllClientFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel getClientFlowsByState(long userId, String flowState, int reqPage, int reqSize) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientFlowWSDTO> clientFlowWSDTOS = clientFlowFramework.getClientFlowsByStateService(userId,flowState,reqPage,reqSize);
        if (clientFlowWSDTOS != null){
            response.setClientFlows(clientFlowWSDTOS);
        }

        general.setOperation("getClientFlowsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowCampaignWSModel getFlowCampaigns(long userId,int reqPage,int reqSize) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowCampaignWSDTO> flowCampaignWSDTOS = clientFlowFramework.getFlowCampaignsService(userId,reqPage,reqSize);
        if (flowCampaignWSDTOS != null){
            response.setFlowCampaigns(flowCampaignWSDTOS);
        }

        general.setOperation("getFlowCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowCampaignWSModel getFlowCampaign(long userId,String campaignId,int reqPage,int reqSize) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowCampaignWSDTO>flowCampaignWSDTOS = new ArrayList<>();

        FlowCampaignWSDTO flowCampaignWSDTO = clientFlowFramework.getFlowCampaignService(userId,campaignId,reqPage,reqSize);
        if (flowCampaignWSDTO != null){
            flowCampaignWSDTOS.add(flowCampaignWSDTO);
        }

        response.setFlowCampaigns(flowCampaignWSDTOS);
        general.setOperation("getFlowCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel getClientFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.getClientFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("getClientFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel createClientFlow(long userId, long clientId, String campaignId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.createClientFlowService(userId,clientId,campaignId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("createClientFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel updateClientFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.updateClientFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("updateFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientFlowWSModel removeClientFlow(long userId, long flowId, long clientId) {

        ClientFlowWSModel response = new ClientFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();

        ClientFlowWSDTO clientFlowWSDTO = clientFlowFramework.removeClientFlowService(userId,flowId,clientId);
        if (clientFlowWSDTO != null){
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }

        response.setClientFlows(clientFlowWSDTOS);
        general.setOperation("removeFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
