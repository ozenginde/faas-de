package com.faas.core.api.framework.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.CampaignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignFramework {

    @Autowired
    CampaignMapper campaignMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentCampaignWSDTO apiGetAgentCampaignService(long agentId) {

        ApiAgentCampaignWSDTO apiAgentCampaignWSDTO = new ApiAgentCampaignWSDTO();
        List<ApiCampaignWSDTO> manualCampaigns = new ArrayList<>();
        List<ApiCampaignWSDTO> inquiryCampaigns = new ArrayList<>();

        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)) {
                manualCampaigns.add(fillApiCampaignWSDTO(agentId, campaignDBModel.get()));
            }
            if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
                inquiryCampaigns.add(fillApiCampaignWSDTO(agentId, campaignDBModel.get()));
            }
        }

        apiAgentCampaignWSDTO.setManualCampaigns(manualCampaigns);
        apiAgentCampaignWSDTO.setInquiryCampaigns(inquiryCampaigns);
        apiAgentCampaignWSDTO.setCampaignSummary(campaignMapper.mapCampaignSummary(agentId));
        apiAgentCampaignWSDTO.setCampaignInquiries(new ArrayList<>());

        return apiAgentCampaignWSDTO;
    }


    public ApiCampaignWSDTO fillApiCampaignWSDTO(long agentId, CampaignDBModel campaignDBModel) {

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        if (processDBModel.isPresent()) {
            campaignWSDTO.setCampaignProcess(processDBModel.get());
        }
        campaignWSDTO.setCampaignSummary(campaignMapper.mapCampaignSummary(agentId));
        return campaignWSDTO;
    }


    public List<ApiCampaignWSDTO> apiGetCampaignsService(long agentId) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent()) {
                campaignWSDTOS.add(fillApiCampaignWSDTO(agentId, campaignDBModel.get()));
            }
        }
        return campaignWSDTOS;
    }


    public List<ApiCampaignWSDTO> apiGetCampaignsByStateService(long agentId, String campaignState) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignState().equalsIgnoreCase(campaignState)) {
                campaignWSDTOS.add(fillApiCampaignWSDTO(agentId, campaignDBModel.get()));
            }
        }
        return campaignWSDTOS;
    }


    public List<ApiCampaignWSDTO> apiGetCampaignsByCategoryService(long agentId, String campaignCategory) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent()) {
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(campaignCategory) || campaignCategory.equalsIgnoreCase(AppConstant.ALL_CAMPAIGNS)) {
                    campaignWSDTOS.add(fillApiCampaignWSDTO(agentId, campaignDBModel.get()));
                }
            }
        }
        return campaignWSDTOS;
    }


    public ApiCampaignWSDTO getApiCampaignService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            ApiCampaignWSDTO apiCampaignWSDTO = new ApiCampaignWSDTO();
            apiCampaignWSDTO.setCampaign(campaignDBModel.get());
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()) {
                apiCampaignWSDTO.setCampaignProcess(processDBModel.get());
            }
            return apiCampaignWSDTO;
        }
        return null;
    }


}
