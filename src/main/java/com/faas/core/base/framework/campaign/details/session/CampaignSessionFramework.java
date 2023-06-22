package com.faas.core.base.framework.campaign.details.session;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.campaign.details.session.dto.CampaignSessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;
import com.faas.core.utils.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CampaignSessionFramework {

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignSessionWSDTO fillCampaignSessionWSDTO(SessionDBModel campaignSession) {

        CampaignSessionWSDTO campaignSessionWSDTO = new CampaignSessionWSDTO();
        campaignSessionWSDTO.setCampaignSession(campaignSession);
        return campaignSessionWSDTO;
    }


    public Page<SessionDBModel> getCampaignSessionsService(String campaignId,int reqPage,int reqSize) {
        return sessionRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
    }


    public Page<SessionDBModel> getCampaignSessionsByStateService(String campaignId,String sessionState,int reqPage,int reqSize) {
        return sessionRepository.findAllByCampaignIdAndSessionState(campaignId,sessionState, PageRequest.of(reqPage,reqSize));
    }


    public SessionDBModel createCampaignSessionService(long userId,String campaignId,long agentId,long clientId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);

        if (campaignDBModel.isPresent() && agentDBModel.isPresent() && clientDBModel.isPresent()){
            clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            SessionDBModel createdSession = sessionRepository.save(sessionMapper.mapSessionDBModel(campaignDBModel.get(),agentDBModel.get(),clientDBModel.get()));
            OperationDBModel createdOperation = operationRepository.save(operationHelper.createOperationHelper(createdSession));

            activityHelper.createOperationActivity(createdSession.getId(),createdOperation.getId(),AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.SESSION_ACTIVITY,String.valueOf(userId),AppConstant.USER_TYPE,String.valueOf(createdSession.getId()),AppConstant.SESSION_TYPE);
            activityHelper.createOperationActivity(createdSession.getId(),createdOperation.getId(),AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.OPERATION_ACTIVITY,String.valueOf(userId),AppConstant.USER_TYPE,String.valueOf(createdSession.getId()),AppConstant.OPERATION_TYPE);

            return createdSession;
        }
        return null;
    }



    public SessionDBModel updateCampaignSessionService(long sessionId,long agentId,String processId,String sessionState) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        if (sessionDBModel.isPresent() && processDBModel.isPresent() && agentDBModel.isPresent()){

            sessionDBModel.get().setProcessId(processDBModel.get().getId());
            sessionDBModel.get().setProcess(processDBModel.get().getProcess());
            sessionDBModel.get().setProcessType(processDBModel.get().getProcessType());
            sessionDBModel.get().setAgentId(agentDBModel.get().getId());
            sessionDBModel.get().setAgentName(agentDBModel.get().getUserName());
            sessionDBModel.get().setSessionState(sessionState);
            sessionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return sessionRepository.save(sessionDBModel.get());
        }
        return null;
    }


    public SessionDBModel removeCampaignSessionService(long sessionId,String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndCampaignId(sessionId,campaignId);
        if (sessionDBModels.size()>0){
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModels.get(0).getClientId());
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            sessionRepository.delete(sessionDBModels.get(0));
            return sessionDBModels.get(0);
        }
        return null;
    }


    public CampaignClientWSDTO fillCampaignClientWSDTO(ClientDBModel clientDBModel) {

        CampaignClientWSDTO campaignClientWSDTO = new CampaignClientWSDTO();
        campaignClientWSDTO.setCampaignClient(clientDBModel);
        return campaignClientWSDTO;
    }


    public Page<ClientDBModel> searchCampaignClientsService(String cityQuery,String countryQuery,String clientState,int reqPage,int reqSize) {

        if (countryQuery.equalsIgnoreCase("")){
            return clientRepository.findAllByClientState(clientState,PageRequest.of(reqPage,reqSize));
        }

        if (cityQuery.equalsIgnoreCase("") && !countryQuery.equalsIgnoreCase("")){
            return clientRepository.findAllByClientCountryAndClientState(countryQuery,clientState,PageRequest.of(reqPage,reqSize));
        }

        if (!cityQuery.equalsIgnoreCase("") && !countryQuery.equalsIgnoreCase("")){
            return clientRepository.findAllByClientCountryAndClientCityContainingIgnoreCaseAndClientState(countryQuery,cityQuery,clientState,PageRequest.of(reqPage,reqSize));
        }
        return null;
    }



}
