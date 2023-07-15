package com.faas.core.api.framework.campaign.details.content;

import com.faas.core.api.model.ws.campaign.details.content.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiCampaignDetailsFramework {

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId, long campaignId) {

        return null;
    }



    public List<ApiSummaryWSDTO> getCampaignSummaryService(long agentId) {

        List<ApiSummaryWSDTO> apiSummaryWSDTOS = new ArrayList<>();
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY, String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        apiSummaryWSDTOS.add(new ApiSummaryWSDTO(AppConstant.TOTAL_SESSIONS_SUMMARY, String.valueOf(sessionRepository.countByAgentId(agentId))));

        return apiSummaryWSDTOS;
    }


}
