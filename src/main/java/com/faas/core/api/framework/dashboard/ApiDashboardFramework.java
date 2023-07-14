package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashSummaryWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import com.faas.core.utils.mapper.CampaignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiDashboardFramework {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    CampaignMapper campaignMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiDashboardWSDTO apiGetDashboardService(long agentId,int reqPage,int reqSize){

        ApiDashboardWSDTO dashboardWSDTO = new ApiDashboardWSDTO();

        dashboardWSDTO.setReadySessions(sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId,AppConstant.READY_SESSION,AppConstant.MANUAL_CAMPAIGN,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setActiveSessions(sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId,AppConstant.ACTIVE_SESSION,AppConstant.MANUAL_CAMPAIGN,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setDashInquiries(null);
        dashboardWSDTO.setDashCampaigns(apiGetDashCampaignService(agentId));
        dashboardWSDTO.setDashSummaries(apiGetDashSummaryService(agentId));

        return dashboardWSDTO;
    }



    public ApiSessionWSDTO apiGetDashSessionService(long agentId,String sessionState,int reqPage,int reqSize){
        return sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionState(agentId,sessionState,PageRequest.of(reqPage,reqSize)));
    }


    public ApiInquiryWSDTO apiGetDashInquiryService(long agentId, String inquiryState, int reqPage, int reqSize){
        return null;
    }


    public List<ApiCampaignWSDTO> apiGetDashCampaignService(long agentId) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> agentCampaigns = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel agentCampaign : agentCampaigns) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(agentCampaign.getCampaignId());
            if (campaignDBModel.isPresent()) {
                ApiCampaignWSDTO campaignWSDTO = fillApiCampaignWSDTO(campaignDBModel.get());
                if (campaignWSDTO != null) {
                    campaignWSDTOS.add(campaignWSDTO);
                }
            }
        }
        return campaignWSDTOS;
    }


    public ApiCampaignWSDTO fillApiCampaignWSDTO(CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        List<ProcessDBModel> processDBModels = processRepository.findByIdAndStatus(campaignDBModel.getProcessId(),1);
        if (processDBModels.size()>0){
            campaignWSDTO.setCampaignProcess(processDBModels.get(0));
        }
        return campaignWSDTO;
    }



    public List<ApiDashSummaryWSDTO> apiGetDashSummaryService(long agentId) {

        List<ApiDashSummaryWSDTO> dashSummaryWSDTOS = new ArrayList<>();
        dashSummaryWSDTOS.add(new ApiDashSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        dashSummaryWSDTOS.add(new ApiDashSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        dashSummaryWSDTOS.add(new ApiDashSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        dashSummaryWSDTOS.add(new ApiDashSummaryWSDTO(AppConstant.FINISHED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.FINISHED_SESSION))));

        return dashSummaryWSDTOS;
    }


}
