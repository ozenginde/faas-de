package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiAgentSessionWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import com.faas.core.utils.mapper.CampaignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiDashboardWSDTO apiGetDashboardService(long agentId){

        ApiDashboardWSDTO dashboardWSDTO = new ApiDashboardWSDTO();
        dashboardWSDTO.setAgentSession(getApiDashboardSessions(agentId,AppConstant.ALL_SESSIONS,0,20));
        dashboardWSDTO.setClientInquiries(new ArrayList<>());
        dashboardWSDTO.setDashCampaigns(getDashCampaignsService(agentId));
        return dashboardWSDTO;
    }


    public ApiAgentSessionWSDTO getApiDashboardSessions(long agentId, String sessionState, int reqPage, int reqSize) {

        ApiAgentSessionWSDTO agentSessionWSDTO = new ApiAgentSessionWSDTO();
        if (sessionState.equalsIgnoreCase(AppConstant.READY_SESSION) || sessionState.equalsIgnoreCase(AppConstant.ALL_SESSIONS)){
            Page<SessionDBModel> readySessionsPage =sessionRepository.findAllByAgentIdAndSessionState(agentId,AppConstant.READY_SESSION, PageRequest.of(reqPage,reqSize));
            if (readySessionsPage != null){
                agentSessionWSDTO.setReadySession(sessionHelper.createApiSessionWSDTO(readySessionsPage));
            }
        }
        if (sessionState.equalsIgnoreCase(AppConstant.ACTIVE_SESSION) || sessionState.equalsIgnoreCase(AppConstant.ALL_SESSIONS)){
            Page<SessionDBModel> activeSessionsPage =sessionRepository.findAllByAgentIdAndSessionState(agentId,AppConstant.ACTIVE_SESSION,PageRequest.of(reqPage,reqSize));
            if (activeSessionsPage != null){
                agentSessionWSDTO.setActiveSession(sessionHelper.createApiSessionWSDTO(activeSessionsPage));
            }
        }
        return agentSessionWSDTO;
    }



    public List<ApiCampaignWSDTO> getDashCampaignsService(long agentId) {

        List<ApiCampaignWSDTO>campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
            List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndStatus(campaignAgentDBModel.getCampaignId(),1);
            if (campaignDBModels.size()>0){
                campaignWSDTOS.add(fillApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
            }
        }
        return campaignWSDTOS;
    }



    public ApiCampaignWSDTO fillApiCampaignWSDTO(long agentId,CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO campaignWSDTO = new ApiCampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        List<ProcessDBModel> processDBModels = processRepository.findByIdAndStatus(campaignDBModel.getProcessId(),1);
        if (processDBModels.size()>0){
            campaignWSDTO.setCampaignProcess(processDBModels.get(0));
        }
        campaignWSDTO.setCampaignSummary(getAgentCampaignSummary(agentId,campaignDBModel.getId()));

        return campaignWSDTO;
    }


    public List<ApiSummaryWSDTO> getAgentCampaignSummary(long agentId,String campaignId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndCampaignIdAndSessionState(agentId,campaignId, AppConstant.READY_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndCampaignIdAndSessionState(agentId, campaignId,AppConstant.ACTIVE_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.COMPLETED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndCampaignIdAndSessionState(agentId, campaignId,AppConstant.COMPLETED_SESSION))));

        return apiSummaryWSDTOS;
    }



    public List<ApiSummaryWSDTO> apiGetDashboardSummaryService(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.COMPLETED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.COMPLETED_SESSION))));

        return apiSummaryWSDTOS;
    }


}
