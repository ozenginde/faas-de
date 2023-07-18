package com.faas.core.base.framework.campaign.details.client.flow;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowWSDTO;
import com.faas.core.base.model.ws.flow.dto.FlowWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.flow.FlowRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.mapper.FlowMapper;
import com.faas.core.utils.mapper.OperationMapper;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CampaignFlowFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    FlowMapper flowMapper;

    @Autowired
    FlowRepository flowRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignFlowWSDTO searchCampaignFlowsService(long userId, String campaignId, String clientCity, String clientCountry, int reqPage, int reqSize) {

        Page<FlowDBModel> flowDBModelPage = flowRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId, clientCity, clientCountry, PageRequest.of(reqPage, reqSize));
        if (flowDBModelPage != null) {
            CampaignFlowWSDTO campaignFlowWSDTO = new CampaignFlowWSDTO();
            campaignFlowWSDTO.setPagination(flowMapper.createFlowPagination(flowDBModelPage));
            campaignFlowWSDTO.setFlows(flowMapper.createFlowWSDTOS(flowDBModelPage.getContent()));
            return campaignFlowWSDTO;
        }
        return null;
    }


    public CampaignFlowWSDTO getCampaignFlowsService(long userId, String campaignId, int reqPage, int reqSize) {

        Page<FlowDBModel> flowDBModelPage = flowRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage, reqSize));
        if (flowDBModelPage != null) {
            CampaignFlowWSDTO campaignFlowWSDTO = new CampaignFlowWSDTO();
            campaignFlowWSDTO.setPagination(flowMapper.createFlowPagination(flowDBModelPage));
            campaignFlowWSDTO.setFlows(flowMapper.createFlowWSDTOS(flowDBModelPage.getContent()));
            return campaignFlowWSDTO;
        }
        return null;
    }


    public FlowWSDTO getCampaignFlowService(long userId, long flowId, long clientId) {

        List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (flowDBModels.size() > 0) {
            return new FlowWSDTO(flowDBModels.get(0));
        }
        return null;
    }


    public FlowWSDTO createCampaignFlowService(long userId, String campaignId, long clientId) {

        if (!flowRepository.existsByClientIdAndCampaignId(clientId,campaignId)){
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByCampaignId(campaignId);
            if (campaignDBModel.isPresent() && clientDBModel.isPresent() && campaignAgents.size() > 0) {
                Optional<UserDBModel> agentDBModel = userRepository.findById(campaignAgents.get(0).getAgentId());
                if (agentDBModel.isPresent()) {

                    clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
                    clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    clientRepository.save(clientDBModel.get());

                    SessionDBModel sessionDBModel = flowMapper.mapFlowSession(agentDBModel.get(),campaignDBModel.get(),clientDBModel.get());
                    operationRepository.save(flowMapper.mapFlowOperation(sessionDBModel));

                    return new FlowWSDTO(flowRepository.save(flowMapper.mapFlowDBModel(sessionDBModel)));
                }
            }
        }
        return null;
    }


    public FlowWSDTO updateCampaignFlowService(long userId, long flowId, long clientId, String flowState) {

        List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (flowDBModels.size() > 0) {
            flowDBModels.get(0).setFlowState(flowState);
            flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new FlowWSDTO(flowRepository.save(flowDBModels.get(0)));
        }
        return null;
    }


    public FlowWSDTO removeCampaignFlowService(long userId, long flowId, long clientId) {

        List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (flowDBModels.size() > 0) {
            flowRepository.delete(flowDBModels.get(0));
            Optional<SessionDBModel>sessionDBModel = sessionRepository.findById(flowDBModels.get(0).getSessionId());
            if(sessionDBModel.isPresent()){
                sessionRepository.delete(sessionDBModel.get());
                operationRepository.deleteAll(operationRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(),clientId));
            }
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            return new FlowWSDTO(flowDBModels.get(0));
        }
        return null;
    }


}
