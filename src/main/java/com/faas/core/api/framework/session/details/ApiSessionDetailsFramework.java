package com.faas.core.api.framework.session.details;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.session.details.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiSessionDetailsFramework {

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ApiSessionDetailsWSDTO apiGetSessionDetailsService(long agentId, long sessionId){

        Optional<SessionDBModel> sessionDBModel =sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return sessionMapper.mapApiSessionDetailsWSDTO(sessionDBModel.get());
        }
        return null;
    }



    public List<ApiSummaryWSDTO> apiGetSessionSummaryService(long agentId) {
        return sessionMapper.getApiSessionsSummary(agentId);
    }



}
