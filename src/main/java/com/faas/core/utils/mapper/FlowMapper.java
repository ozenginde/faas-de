package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.flow.dto.FlowWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlowMapper {


    @Autowired
    AppUtils appUtils;


    public FlowDBModel mapFlowDBModel(CampaignDBModel campaignDBModel, ClientDBModel clientDBModel, UserDBModel agentDBModel){

        FlowDBModel flowDBModel = new FlowDBModel();

        flowDBModel.setSessionId(0);
        flowDBModel.setSessionUUID("");
        flowDBModel.setClientId(clientDBModel.getId());
        flowDBModel.setClientName(clientDBModel.getClientName());
        flowDBModel.setNationalId(clientDBModel.getNationalId());
        flowDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        flowDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        flowDBModel.setClientCity(clientDBModel.getClientCity());
        flowDBModel.setClientCountry(clientDBModel.getClientCountry());
        flowDBModel.setClientType(clientDBModel.getClientType());
        flowDBModel.setCampaignId(campaignDBModel.getId());
        flowDBModel.setCampaign(campaignDBModel.getCampaign());
        flowDBModel.setCampaignType(campaignDBModel.getCampaignType());
        flowDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        flowDBModel.setProcessId(campaignDBModel.getProcessId());
        flowDBModel.setProcess(campaignDBModel.getProcess());
        flowDBModel.setProcessType(campaignDBModel.getProcessType());
        flowDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        flowDBModel.setAgentId(agentDBModel.getId());
        flowDBModel.setAgentName(agentDBModel.getUserName());
        flowDBModel.setFlowState(AppConstant.READY_FLOW);
        flowDBModel.setuDate(appUtils.getCurrentTimeStamp());
        flowDBModel.setcDate(appUtils.getCurrentTimeStamp());
        flowDBModel.setStatus(1);

        return flowDBModel;
    }


    public List<FlowWSDTO> createFlowWSDTOS(List<FlowDBModel> flowDBModels){

        List<FlowWSDTO> flowWSDTOS = new ArrayList<>();
        for (FlowDBModel flowDBModel : flowDBModels) {
            FlowWSDTO flowWSDTO = new FlowWSDTO();
            flowWSDTO.setFlow(flowDBModel);
            flowWSDTOS.add(flowWSDTO);
        }
        return flowWSDTOS;
    }


    public PaginationWSDTO createFlowPagination(Page<FlowDBModel> flowDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(flowDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(flowDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(flowDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(flowDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


}
