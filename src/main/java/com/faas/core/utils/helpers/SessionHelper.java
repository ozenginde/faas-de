package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.session.content.dto.ApiAgentSessionWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SessionHelper {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    AppUtils appUtils;



    public ApiSessionWSDTO mapApiSessionWSDTO(Page<SessionDBModel> sessionPage) {

        ApiSessionWSDTO apiSessionWSDTO = new ApiSessionWSDTO();
        apiSessionWSDTO.setSessions(sessionPage.getContent());
        PaginationWSDTO paginationWSDTO = sessionMapper.createSessionPaginationWSDTO(sessionPage);
        if (paginationWSDTO != null){
            apiSessionWSDTO.setPagination(paginationWSDTO);
        }
        return apiSessionWSDTO;
    }



    public ApiSessionWSDTO getApiSessionWSDTO(long agentId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionsPage = sessionRepository.findAllByAgentIdAndSessionStateAndSessionType(agentId,sessionState,AppConstant.MANUAL_CAMPAIGN,PageRequest.of(reqPage,reqSize));
        if (sessionsPage != null){
            ApiSessionWSDTO apiSessionWSDTO  = new ApiSessionWSDTO();
            apiSessionWSDTO.setPagination(sessionMapper.createSessionPaginationWSDTO(sessionsPage));
            apiSessionWSDTO.setSessions(sessionsPage.getContent());
            return apiSessionWSDTO;
        }
        return null;
    }


}
