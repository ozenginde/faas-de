package com.faas.core.base.framework.flow;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.flow.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.flow.ClientFlowRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ClientFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientFlowFramework {

    @Autowired
    ClientFlowMapper clientFlowMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientFlowRepository clientFlowRepository;

    @Autowired
    AppUtils appUtils;


    public List<ClientFlowWSDTO> getAllClientFlowsService(long userId, int reqPage, int reqSize) {

        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();
        Page<ClientFlowDBModel> flowModelPage = clientFlowRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            clientFlowWSDTOS.add(new ClientFlowWSDTO(flowModelPage.getContent().get(i)));
        }
        return clientFlowWSDTOS;
    }

    public List<ClientFlowWSDTO> getClientFlowsByStateService(long userId, String flowState, int reqPage, int reqSize) {

        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();
        Page<ClientFlowDBModel> flowModelPage = clientFlowRepository.findAllByFlowState(flowState,PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            clientFlowWSDTOS.add(new ClientFlowWSDTO(flowModelPage.getContent().get(i)));
        }
        return clientFlowWSDTOS;
    }


    public List<FlowCampaignWSDTO> getFlowCampaignsService(long userId,int reqPage,int reqSize) {

        List<FlowCampaignWSDTO>flowCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        if (campaignDBModels.size()>0){
            for (CampaignDBModel campaignDBModel : campaignDBModels) {
                FlowCampaignWSDTO flowCampaignWSDTO = new FlowCampaignWSDTO();
                flowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
                Page<ClientFlowDBModel> flowModelPage = clientFlowRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
                flowCampaignWSDTO.setFlows(clientFlowMapper.createClientFlowWSDTOS(flowModelPage.getContent()));
                flowCampaignWSDTO.setPagination(clientFlowMapper.createClientFlowPagination(flowModelPage));

                flowCampaignWSDTOS.add(flowCampaignWSDTO);
            }
        }
        return flowCampaignWSDTOS;
    }


    public FlowCampaignWSDTO getFlowCampaignService(long userId,String campaignId,int reqPage,int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            FlowCampaignWSDTO flowCampaignWSDTO = new FlowCampaignWSDTO();
            flowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel.get()));
            Page<ClientFlowDBModel> flowModelPage = clientFlowRepository.findAllByCampaignId(campaignId,PageRequest.of(reqPage,reqSize));
            flowCampaignWSDTO.setFlows(clientFlowMapper.createClientFlowWSDTOS(flowModelPage.getContent()));
            flowCampaignWSDTO.setPagination(clientFlowMapper.createClientFlowPagination(flowModelPage));

            return flowCampaignWSDTO;
        }
        return null;
    }


    public ClientFlowWSDTO getClientFlowService(long userId, long flowId, long clientId) {

        List<ClientFlowDBModel> clientFlowDBModels = clientFlowRepository.findByIdAndClientId(flowId,clientId);
        if (clientFlowDBModels.size()>0){
            return new ClientFlowWSDTO(clientFlowDBModels.get(0));
        }
        return null;
    }


    public ClientFlowWSDTO createClientFlowService(long userId, long clientId, String campaignId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignId(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)
                && campaignAgentDBModels.size()>0 && clientDBModel.isPresent()){
            Optional<UserDBModel> agentDBModel = userRepository.findById(campaignAgentDBModels.get(0).getAgentId());
            if (agentDBModel.isPresent()){
                ClientFlowDBModel clientFlowDBModel = clientFlowMapper.mapFlowDBModel(campaignDBModel.get(),clientDBModel.get(),agentDBModel.get());
                if (clientFlowDBModel != null){
                    return new ClientFlowWSDTO(clientFlowRepository.save(clientFlowDBModel));
                }
            }
        }
        return null;
    }


    public ClientFlowWSDTO updateClientFlowService(long userId, long flowId, long clientId) {

        List<ClientFlowDBModel> clientFlowDBModels = clientFlowRepository.findByIdAndClientId(flowId,clientId);
        if (clientFlowDBModels.size()>0){
            return new ClientFlowWSDTO(clientFlowDBModels.get(0));
        }
        return null;
    }

    public ClientFlowWSDTO removeClientFlowService(long userId, long flowId, long clientId) {

        List<ClientFlowDBModel> clientFlowDBModels = clientFlowRepository.findByIdAndClientId(flowId,clientId);
        if (clientFlowDBModels.size()>0){
            clientFlowRepository.delete(clientFlowDBModels.get(0));
            return new ClientFlowWSDTO(clientFlowDBModels.get(0));
        }
        return null;
    }


}
