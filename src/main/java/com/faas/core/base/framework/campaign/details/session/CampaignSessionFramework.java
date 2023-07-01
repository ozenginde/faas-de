package com.faas.core.base.framework.campaign.details.session;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.session.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.session.content.CreateSessionRequest;
import com.faas.core.base.model.ws.session.content.dto.CreateSessionRequestDTO;
import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
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

import java.util.ArrayList;
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


    public CampaignSessionWSDTO searchCampaignSessionsService(long userId,String campaignId,String city,String country,String sessionState,int reqPage,int reqSize) {

        return null;
    }


    public CampaignSessionWSDTO getCampaignSessionsService(long userId,String campaignId,String sessionState,int reqPage,int reqSize) {

        Page<SessionDBModel> sessionModels = sessionRepository.findAllByCampaignIdAndSessionState(campaignId,sessionState, PageRequest.of(reqPage,reqSize));
        if (sessionModels != null){
            CampaignSessionWSDTO campaignSessionWSDTO = new CampaignSessionWSDTO();
            campaignSessionWSDTO.setPagination(sessionMapper.createSessionPaginationWSDTO(sessionModels));
            campaignSessionWSDTO.setSessions(sessionMapper.mapSessionWSDTOS(sessionModels.getContent()));
            return campaignSessionWSDTO;
        }
        return null;
    }



    public SessionWSDTO getCampaignSessionService(long userId, long sessionId, long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        if (sessionDBModels.size()>0){
            return new SessionWSDTO(sessionDBModels.get(0));
        }
        return null;
    }



    public List<SessionWSDTO> createCampaignSessionsService(CreateSessionRequest createSession) {

        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();
        for (int i=0;i<createSession.getCreateSessions().size();i++){
            CreateSessionRequestDTO createSessionRequestDTO = createSession.getCreateSessions().get(i);
            SessionWSDTO sessionWSDTO = createCampaignSessionService(createSessionRequestDTO.getUserId(), createSessionRequestDTO.getCampaignId(), createSessionRequestDTO.getAgentId(), createSessionRequestDTO.getClientId());
            if (sessionWSDTO != null){
                sessionWSDTOS.add(sessionWSDTO);
            }
        }
        return sessionWSDTOS;
    }



    public SessionWSDTO createCampaignSessionService(long userId,String campaignId,long agentId,long clientId) {

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

            return new SessionWSDTO(createdSession);
        }
        return null;
    }



    public SessionWSDTO updateCampaignSessionService(long userId,long sessionId,long agentId,String campaignId,String sessionState) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (sessionDBModel.isPresent() && campaignDBModel.isPresent() && agentDBModel.isPresent()){

            sessionDBModel.get().setCampaignId(campaignDBModel.get().getCampaign());
            sessionDBModel.get().setCampaign(campaignDBModel.get().getCampaign());
            sessionDBModel.get().setCampaignType(campaignDBModel.get().getCampaignType());
            sessionDBModel.get().setProcessId(campaignDBModel.get().getProcessId());
            sessionDBModel.get().setProcess(campaignDBModel.get().getProcess());
            sessionDBModel.get().setProcessType(campaignDBModel.get().getProcessType());
            sessionDBModel.get().setProcessCategory(campaignDBModel.get().getProcessCategory());
            sessionDBModel.get().setAgentId(agentDBModel.get().getId());
            sessionDBModel.get().setAgentName(agentDBModel.get().getUserName());
            sessionDBModel.get().setSessionState(sessionState);
            sessionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new SessionWSDTO(sessionRepository.save(sessionDBModel.get()));
        }
        return null;
    }


    public SessionWSDTO removeCampaignSessionService(long userId,long sessionId,long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        if (sessionDBModels.size()>0){
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModels.get(0).getClientId());
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            sessionRepository.delete(sessionDBModels.get(0));
            return new SessionWSDTO(sessionDBModels.get(0));
        }
        return null;
    }


}
