package com.faas.core.base.middleware.flow.content;

import com.faas.core.base.framework.flow.content.FlowFramework;
import com.faas.core.base.model.ws.flow.content.FlowCampaignWSModel;
import com.faas.core.base.model.ws.flow.content.FlowWSModel;
import com.faas.core.base.model.ws.flow.content.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.flow.content.dto.FlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FlowMiddleware {


    @Autowired
    FlowFramework flowFramework;


    public FlowWSModel getAllFlows(long userId, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowWSDTO> flowWSDTOS = flowFramework.getAllFlowsService(userId,reqPage,reqSize);
        if (flowWSDTOS != null){
            response.setFlows(flowWSDTOS);
        }

        general.setOperation("getAllFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel getFlowsByState(long userId,String flowState, int reqPage, int reqSize) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowWSDTO> flowWSDTOS = flowFramework.getFlowsByStateService(userId,flowState,reqPage,reqSize);
        if (flowWSDTOS != null){
            response.setFlows(flowWSDTOS);
        }

        general.setOperation("getFlowsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowCampaignWSModel getFlowCampaigns(long userId) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowCampaignWSDTO> flowCampaignWSDTOS = flowFramework.getFlowCampaignsService(userId);
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


    public FlowCampaignWSModel getFlowCampaign(long userId,String campaignId) {

        FlowCampaignWSModel response = new FlowCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowCampaignWSDTO>flowCampaignWSDTOS = new ArrayList<>();

        FlowCampaignWSDTO flowCampaignWSDTO = flowFramework.getFlowCampaignService(userId,campaignId);
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


    public FlowWSModel getFlow(long userId,long flowId,long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = flowFramework.getFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("getFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel createFlow(long userId, long clientId,String campaignId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = flowFramework.createFlowService(userId,clientId,campaignId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("createFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel updateFlow(long userId,long flowId,long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = flowFramework.updateFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("updateFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowWSModel removeFlow(long userId,long flowId,long clientId) {

        FlowWSModel response = new FlowWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();

        FlowWSDTO flowWSDTO = flowFramework.removeFlowService(userId,flowId,clientId);
        if (flowWSDTO != null){
            flowWSDTOS.add(flowWSDTO);
        }

        response.setFlows(flowWSDTOS);
        general.setOperation("removeFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
