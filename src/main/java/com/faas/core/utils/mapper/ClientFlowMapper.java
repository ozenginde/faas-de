package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.flow.content.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientFlowMapper {


    @Autowired
    AppUtils appUtils;


    public ClientFlowDBModel mapFlowDBModel(CampaignDBModel campaignDBModel, ClientDBModel clientDBModel, UserDBModel agentDBModel){

        ClientFlowDBModel clientFlowDBModel = new ClientFlowDBModel();

        clientFlowDBModel.setSessionId(0);
        clientFlowDBModel.setSessionUUID("");
        clientFlowDBModel.setClientId(clientDBModel.getId());
        clientFlowDBModel.setClientName(clientDBModel.getClientName());
        clientFlowDBModel.setNationalId(clientDBModel.getNationalId());
        clientFlowDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        clientFlowDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        clientFlowDBModel.setClientCity(clientDBModel.getClientCity());
        clientFlowDBModel.setClientCountry(clientDBModel.getClientCountry());
        clientFlowDBModel.setClientType(clientDBModel.getClientType());
        clientFlowDBModel.setCampaignId(campaignDBModel.getId());
        clientFlowDBModel.setCampaign(campaignDBModel.getCampaign());
        clientFlowDBModel.setCampaignType(campaignDBModel.getCampaignType());
        clientFlowDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        clientFlowDBModel.setProcessId(campaignDBModel.getProcessId());
        clientFlowDBModel.setProcess(campaignDBModel.getProcess());
        clientFlowDBModel.setProcessType(campaignDBModel.getProcessType());
        clientFlowDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        clientFlowDBModel.setAgentId(agentDBModel.getId());
        clientFlowDBModel.setAgentName(agentDBModel.getUserName());
        clientFlowDBModel.setFlowState(AppConstant.READY_FLOW);
        clientFlowDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientFlowDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientFlowDBModel.setStatus(1);

        return clientFlowDBModel;
    }


    public List<ClientFlowWSDTO> createClientFlowWSDTOS(List<ClientFlowDBModel> clientFlowDBModels){

        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();
        for (ClientFlowDBModel clientFlowDBModel : clientFlowDBModels) {
            ClientFlowWSDTO clientFlowWSDTO = new ClientFlowWSDTO();
            clientFlowWSDTO.setClientFlow(clientFlowDBModel);
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }
        return clientFlowWSDTOS;
    }


    public PaginationWSDTO createClientFlowPagination(Page<ClientFlowDBModel> flowDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(flowDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(flowDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(flowDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(flowDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


}
