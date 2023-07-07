package com.faas.core.base.framework.flow.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.flow.content.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.flow.content.dto.FlowWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.flow.FlowRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.FlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class FlowFramework {

    @Autowired
    FlowMapper flowMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FlowRepository flowRepository;

    @Autowired
    AppUtils appUtils;


    public List<FlowWSDTO> getAllFlowsService(long userId, int reqPage, int reqSize) {

        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();
        Page<FlowDBModel> flowModelPage = flowRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            flowWSDTOS.add(new FlowWSDTO(flowModelPage.getContent().get(i)));
        }
        return flowWSDTOS;
    }

    public List<FlowWSDTO> getFlowsByStateService(long userId,String flowState, int reqPage, int reqSize) {

        List<FlowWSDTO>flowWSDTOS = new ArrayList<>();
        Page<FlowDBModel> flowModelPage = flowRepository.findAllByFlowState(flowState,PageRequest.of(reqPage,reqSize));
        for (int i=0;i<flowModelPage.getContent().size();i++){
            flowWSDTOS.add(new FlowWSDTO(flowModelPage.getContent().get(i)));
        }
        return flowWSDTOS;
    }


    public List<FlowCampaignWSDTO> getFlowCampaignsService(long userId,int reqPage,int reqSize) {

        List<FlowCampaignWSDTO>flowCampaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.AUTOMATIC_CAMPAIGN);
        if (campaignDBModels.size()>0){
            for (CampaignDBModel campaignDBModel : campaignDBModels) {
                FlowCampaignWSDTO flowCampaignWSDTO = new FlowCampaignWSDTO();
                flowCampaignWSDTO.setCampaign(new CampaignWSDTO(campaignDBModel));
                Page<FlowDBModel> flowModelPage = flowRepository.findAllByCampaignId(campaignDBModel.getId(), PageRequest.of(reqPage, reqSize));
                flowCampaignWSDTO.setFlows(flowMapper.createFlowWSDTOS(flowModelPage.getContent()));
                flowCampaignWSDTO.setPagination(flowMapper.createFlowPaginationWSDTO(flowModelPage));

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
            Page<FlowDBModel> flowModelPage = flowRepository.findAllByCampaignId(campaignId,PageRequest.of(reqPage,reqSize));
            flowCampaignWSDTO.setFlows(flowMapper.createFlowWSDTOS(flowModelPage.getContent()));
            flowCampaignWSDTO.setPagination(flowMapper.createFlowPaginationWSDTO(flowModelPage));

            return flowCampaignWSDTO;
        }
        return null;
    }


    public FlowWSDTO getFlowService(long userId,long flowId,long clientId) {

        List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
        if (flowDBModels.size()>0){
            return new FlowWSDTO(flowDBModels.get(0));
        }
        return null;
    }


    public FlowWSDTO createFlowService(long userId, long clientId,String campaignId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignId(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)
                && campaignAgentDBModels.size()>0 && clientDBModel.isPresent()){
            Optional<UserDBModel> agentDBModel = userRepository.findById(campaignAgentDBModels.get(0).getAgentId());
            if (agentDBModel.isPresent()){
                FlowDBModel flowDBModel = flowMapper.mapFlowDBModel(campaignDBModel.get(),clientDBModel.get(),agentDBModel.get());
                if (flowDBModel != null){
                    return new FlowWSDTO(flowRepository.save(flowDBModel));
                }
            }
        }
        return null;
    }


    public FlowWSDTO updateFlowService(long userId,long flowId,long clientId) {

        List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
        if (flowDBModels.size()>0){
            return new FlowWSDTO(flowDBModels.get(0));
        }
        return null;
    }

    public FlowWSDTO removeFlowService(long userId,long flowId,long clientId) {

        List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId,clientId);
        if (flowDBModels.size()>0){
            flowRepository.delete(flowDBModels.get(0));
            return new FlowWSDTO(flowDBModels.get(0));
        }
        return null;
    }


}
