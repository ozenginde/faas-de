package com.faas.core.api.framework.session.content;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiAgentSessionWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiCampaignSessionWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import com.faas.core.utils.mapper.CampaignMapper;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiSessionFramework {

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    CampaignMapper campaignMapper;

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentSessionWSDTO apiGetAgentSessionService(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSDTO agentSessionWSDTO = new ApiAgentSessionWSDTO();
        agentSessionWSDTO.setReadySession(sessionHelper.getApiSessionWSDTO(agentId,AppConstant.READY_SESSION,reqPage,reqSize));
        agentSessionWSDTO.setActiveSession(sessionHelper.getApiSessionWSDTO(agentId,AppConstant.ACTIVE_SESSION,reqPage,reqSize));

        return agentSessionWSDTO;
    }


    public ApiSessionWSDTO fillApiSessionWSDTO(List<SessionDBModel> sessionDBModels,PaginationWSDTO pagination) {

        ApiSessionWSDTO apiSessionWSDTO = new ApiSessionWSDTO();
        apiSessionWSDTO.setSessions(sessionDBModels);
        if (pagination != null){
            apiSessionWSDTO.setPagination(pagination);
        }
        return apiSessionWSDTO;
    }


    public ApiSessionWSDTO apiGetSessionsService(long agentId,String sessionState,int reqPage,int reqSize) {

        Page<SessionDBModel> sessionModelPage =sessionRepository.findAllByAgentIdAndSessionState(agentId,sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return fillApiSessionWSDTO(sessionModelPage.getContent(),sessionMapper.createSessionPaginationWSDTO(sessionModelPage)) ;
        }
        return null;
    }



    public ApiCampaignSessionWSDTO apiGetCampaignSessionsService(long agentId, String campaignId, String sessionState, int reqPage, int reqSize) {

        return null;
    }


    public ApiSessionWSDTO apiGetSessionService(long agentId, long sessionId) {

        return null;
    }


    public List<ApiSummaryWSDTO> apiGetSessionSummaryService(long agentId) {
        return sessionMapper.getApiSessionSummary(agentId);
    }





}
