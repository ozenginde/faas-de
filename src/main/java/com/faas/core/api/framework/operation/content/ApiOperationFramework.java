package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    OperationMapper operationMapper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;



    public ApiOperationDetailsWSDTO apiOperationValidateService(long agentId, long sessionId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId, agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);

        if (sessionDBModels.size() > 0 && operationDBModels.size() > 0) {

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModels.get(0).getClientId());
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(sessionDBModels.get(0).getCampaignId());
            Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModels.get(0).getProcessId());
            if (clientDBModel.isPresent() && campaignDBModel.isPresent() && processDBModel.isPresent()) {
                return operationMapper.mapApiOperationDetailsWSDTO(sessionDBModels.get(0), clientDBModel.get(), operationDBModels.get(0),
                        campaignDBModel.get(), processDBModel.get());
            }
        }
        return null;
    }


    public ApiOperationWSDTO apiGetOperationService(long agentId, long sessionId, long clientId) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientId(sessionId, clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId, clientId);
        if (sessionDBModels.size() > 0 && operationDBModels.size() > 0) {
            return new ApiOperationWSDTO(operationDBModels.get(0), sessionDBModels.get(0));
        }
        return null;
    }


    public ApiOperationWSDTO apiStartOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.READY_SESSION);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(sessionId, clientId, agentId, campaignId, AppConstant.READY_OPERATION);
        if (sessionDBModels.size() > 0 && operationDBModels.size() > 0) {

            sessionDBModels.get(0).setSessionState(AppConstant.ACTIVE_SESSION);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            SessionDBModel updatedSession = sessionRepository.save(sessionDBModels.get(0));

            operationDBModels.get(0).setOperationState(AppConstant.ACTIVE_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            OperationDBModel updatedOperation = operationRepository.save(operationDBModels.get(0));

            activityHelper.createOperationActivity(updatedOperation.getSessionId(), updatedOperation.getId(), AppConstant.START_OPERATION_ACTIVITY,
                    AppConstant.OPERATION_ACTIVITY, String.valueOf(updatedOperation.getAgentId()), AppConstant.USER_TYPE, updatedOperation.getId(), AppConstant.OPERATION_TYPE);

            return new ApiOperationWSDTO(updatedOperation, updatedSession);
        }
        return null;
    }


    public ApiOperationWSDTO apiUpdateOperationService(long agentId, long sessionId, long clientId, String campaignId, String operationResult) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.ACTIVE_SESSION);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentId(sessionId, clientId, agentId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (sessionDBModels.size() > 0 && operationDBModels.size() > 0 && clientDBModel.isPresent()) {

            sessionDBModels.get(0).setSessionState(AppConstant.FINISHED_SESSION);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            SessionDBModel updatedSession = sessionRepository.save(sessionDBModels.get(0));

            operationDBModels.get(0).setOperationResult(operationResult);
            operationDBModels.get(0).setOperationState(AppConstant.FINISHED_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            OperationDBModel updatedOperation = operationRepository.save(operationDBModels.get(0));

            clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            return new ApiOperationWSDTO(updatedOperation, updatedSession);
        }
        return null;
    }


    public ApiOperationWSDTO apiRemoveOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignId(sessionId, clientId, agentId, campaignId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentId(sessionId, clientId, agentId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);


        return null;
    }


}
