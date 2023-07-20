package com.faas.core.api.framework.dashboard;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
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
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.helpers.SessionHelper;
import com.faas.core.utils.mapper.CampaignMapper;
import com.faas.core.utils.mapper.InquiryMapper;
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
    InquiryHelper inquiryHelper;

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
        dashboardWSDTO.setReadySession(sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionState(agentId,AppConstant.READY_SESSION,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setActiveSession(sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionState(agentId,AppConstant.ACTIVE_SESSION,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setDashInquiry(inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,AppConstant.NEW_INQUIRY,PageRequest.of(reqPage,reqSize))));
        dashboardWSDTO.setDashCampaigns(apiGetDashCampaignService(agentId));

        return dashboardWSDTO;
    }



    public ApiSessionWSDTO apiGetDashSessionService(long agentId,String sessionState,int reqPage,int reqSize){
        return sessionHelper.mapApiSessionWSDTO(sessionRepository.findAllByAgentIdAndSessionState(agentId,sessionState,PageRequest.of(reqPage,reqSize)));
    }


    public ApiInquiryWSDTO apiGetDashInquiryService(long agentId,  int reqPage, int reqSize){
        return inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,AppConstant.READY_INQUIRY,PageRequest.of(reqPage,reqSize)));
    }


    public List<ApiCampaignWSDTO> apiGetDashCampaignService(long agentId) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> agentCampaigns = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel agentCampaign : agentCampaigns) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(agentCampaign.getCampaignId());
            if (campaignDBModel.isPresent()) {
                ApiCampaignWSDTO campaignWSDTO = fillApiDashCampaignWSDTO(agentId,campaignDBModel.get());
                if (campaignWSDTO != null) {
                    campaignWSDTOS.add(campaignWSDTO);
                }
            }
        }
        return campaignWSDTOS;
    }


    public ApiCampaignWSDTO fillApiDashCampaignWSDTO(long agentId,CampaignDBModel campaignDBModel){

        ApiCampaignWSDTO dashCampaignWSDTO = new ApiCampaignWSDTO();

        dashCampaignWSDTO.setCampaign(campaignDBModel);
        List<ProcessDBModel> processDBModels = processRepository.findByIdAndStatus(campaignDBModel.getProcessId(),1);
        if (processDBModels.size()>0){
            dashCampaignWSDTO.setCampaignProcess(processDBModels.get(0));
        }

        List<ApiSummaryWSDTO> summaries = new ArrayList<>();
        summaries.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId,AppConstant.READY_SESSION))));
        summaries.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId,AppConstant.ACTIVE_SESSION))));
        dashCampaignWSDTO.setSummaries(summaries);

        return dashCampaignWSDTO;
    }



    public List<ApiSummaryWSDTO> apiGetDashSummaryService(long agentId) {

        List<ApiSummaryWSDTO> summaryWSDTOS = new ArrayList<>();
        summaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        summaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        summaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        summaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.FINISHED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.FINISHED_SESSION))));

        return summaryWSDTOS;
    }


}
