package com.faas.core.api.framework.campaign.process.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiCampaignProcessDetailsFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;

    public ApiCampaignDetailsWSDTO apiGetCampaignProcessDetailsService(long agentId, long campaignId) {

        return null;
    }


}
