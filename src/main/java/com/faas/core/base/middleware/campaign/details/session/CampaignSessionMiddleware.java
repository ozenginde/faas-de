package com.faas.core.base.middleware.campaign.details.session;

import com.faas.core.base.framework.campaign.details.session.CampaignSessionFramework;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.campaign.details.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.campaign.details.session.CampaignSessionWSModel;
import com.faas.core.base.model.ws.campaign.details.session.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.session.content.CreateSessionRequestModel;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.mapper.ClientMapper;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignSessionMiddleware {

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    CampaignSessionFramework campaignSessionFramework;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignSessionWSModel getCampaignSessions(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        Page<SessionDBModel> campaignSession =  campaignSessionFramework.getCampaignSessionsService(campaignId,reqPage,reqSize);
        if (campaignSession != null){
            response.setPagination(sessionMapper.createSessionPaginationWSDTO(campaignSession));
            for (int i=0;i<campaignSession.getContent().size();i++){
                campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(campaignSession.getContent().get(i)));
            }
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("getCampaignSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel getCampaignSessionsByState(long userId,String campaignId,String sessionState,int reqPage,int reqSize) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        Page<SessionDBModel> campaignSession =  campaignSessionFramework.getCampaignSessionsByStateService(campaignId,sessionState,reqPage,reqSize);
        if (campaignSession != null){
            response.setPagination(sessionMapper.createSessionPaginationWSDTO(campaignSession));
            for (int i=0;i<campaignSession.getContent().size();i++){
                campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(campaignSession.getContent().get(i)));
            }
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("getCampaignSessionsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel getCampaignSession(long userId,long sessionId,String campaignId) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndCampaignId(sessionId,campaignId);
        if (sessionDBModels.size()>0){
            campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(sessionDBModels.get(0)));
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("getCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel createCampaignSession(long userId,String campaignId,long clientId,long agentId) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        SessionDBModel sessionDBModel = campaignSessionFramework.createCampaignSessionService(userId,campaignId,agentId,clientId);
        if (sessionDBModel != null){
            campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(sessionDBModel));
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("createCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel createCampaignSessions(CreateSessionRequestModel sessionRequest) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        if (sessionRequest.getSessionRequests() != null){
            for (int i=0;i<sessionRequest.getSessionRequests().size();i++){
                SessionDBModel sessionDBModel = campaignSessionFramework.createCampaignSessionService(sessionRequest.getSessionRequests().get(i).getUserId(),sessionRequest.getSessionRequests().get(i).getCampaignId(), sessionRequest.getSessionRequests().get(i).getAgentId(), sessionRequest.getSessionRequests().get(i).getClientId());
                if (sessionDBModel != null){
                    campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(sessionDBModel));
                }
            }
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("createCampaignSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel updateCampaignSession(long userId,long sessionId,long agentId,String processId,String sessionState) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        SessionDBModel sessionDBModel = campaignSessionFramework.updateCampaignSessionService(sessionId,agentId,processId,sessionState);
        if (sessionDBModel != null){
            campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(sessionDBModel));
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("updateCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignSessionWSModel removeCampaignSession(long userId,long sessionId,String campaignId) {

        CampaignSessionWSModel response = new CampaignSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSessionWSDTO>campaignSessionWSDTOS = new ArrayList<>();

        SessionDBModel sessionDBModel = campaignSessionFramework.removeCampaignSessionService(sessionId,campaignId);
        if (sessionDBModel != null){
            campaignSessionWSDTOS.add(campaignSessionFramework.fillCampaignSessionWSDTO(sessionDBModel));
        }

        response.setCampaignSessions(campaignSessionWSDTOS);
        general.setOperation("removeCampaignSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignClientWSModel searchCampaignClients(long userId, String cityQuery, String countryQuery, String clientState, int reqPage, int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignClientWSDTO>campaignClientWSDTOS = new ArrayList<>();

        Page<ClientDBModel>campaignClient = campaignSessionFramework.searchCampaignClientsService(cityQuery,countryQuery,clientState,reqPage,reqSize);
        if (campaignClient != null){
            response.setPagination(clientMapper.createClientPaginationWSDTO(campaignClient));
            for (int i=0;i<campaignClient.getContent().size();i++){
                campaignClientWSDTOS.add(campaignSessionFramework.fillCampaignClientWSDTO(campaignClient.getContent().get(i)));
            }
        }

        response.setCampaignClients(campaignClientWSDTOS);
        general.setOperation("searchCampaignClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
