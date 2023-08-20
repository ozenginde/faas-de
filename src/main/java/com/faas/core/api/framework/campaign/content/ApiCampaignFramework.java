package com.faas.core.api.framework.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignFramework {

    @Autowired
    CampaignHelper campaignHelper;

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

        return apiAgentCampaignWSDTO;
    }


    public List<ApiCampaignWSDTO> apiGetCampaignsService(long agentId, String category) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent()) {
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(category) || category.equalsIgnoreCase(AppConstant.ALL_CAMPAIGNS)) {
                    campaignWSDTOS.add(fillApiCampaignWSDTO(agentId, campaignDBModel.get()));
                }
            }
        }
        return campaignWSDTOS;
    }


    public ApiCampaignWSDTO getApiCampaignService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()) {
                campaignWSDTO.setCampaignProcess(processDBModel.get());
            }
            campaignWSDTO.setSummaries(campaignHelper.mapCampaignSummary(agentId, campaignDBModel.get().getCampaign()));
            return campaignWSDTO;
        }
        return null;
    }


    public ApiCampaignWSDTO fillApiCampaignWSDTO(long agentId, CampaignDBModel campaignDBModel) {

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        if (processDBModel.isPresent()) {
            campaignWSDTO.setCampaignProcess(processDBModel.get());
        }
        campaignWSDTO.setSummaries(campaignHelper.mapCampaignSummary(agentId, campaignDBModel.getId()));
        return campaignWSDTO;
    }


    public List<ApiSummaryWSDTO> apiGetAgentCampaignSummaryService(long agentId) {
        return campaignHelper.mapAgentCampaignSummary(agentId);
    }


}
