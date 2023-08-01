package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.flow.FlowRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
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
    InquiryRepository inquiryRepository;

    @Autowired
    FlowRepository flowRepository;

    @Autowired
    AppUtils appUtils;





    public ApiOperationDetailsWSDTO apiOperationValidateService(long agentId, long sessionId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId, agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (!sessionDBModels.isEmpty() && !operationDBModels.isEmpty()) {

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModels.get(0).getClientId());
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(sessionDBModels.get(0).getCampaignId());
            Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModels.get(0).getProcessId());
            if (clientDBModel.isPresent() && campaignDBModel.isPresent() && processDBModel.isPresent()) {
                return operationMapper.mapApiOperationDetailsWSDTO(sessionDBModels.get(0), clientDBModel.get(), operationDBModels.get(0), campaignDBModel.get(), processDBModel.get());
            }
        }
        return null;
    }


    public ApiOperationWSDTO apiGetOperationService(long agentId, long sessionId, long clientId) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientId(sessionId, clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId, clientId);
        if (sessionDBModels.size() > 0 && operationDBModels.size() > 0) {

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
            operationWSDTO.setOperation(operationDBModels.get(0));
            operationWSDTO.setOperationSession(sessionDBModels.get(0));

            return operationWSDTO;
        }
        return null;
    }


    public ApiOperationWSDTO apiLaunchOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.READY_SESSION);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(sessionId, clientId, agentId, campaignId, AppConstant.READY_OPERATION);
        if (sessionDBModels.size() > 0 && operationDBModels.size() > 0) {

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();

            sessionDBModels.get(0).setSessionState(AppConstant.ACTIVE_SESSION);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            SessionDBModel operationSession = sessionRepository.save(sessionDBModels.get(0));
            operationWSDTO.setOperationSession(operationSession);

            operationDBModels.get(0).setOperationState(AppConstant.ACTIVE_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            OperationDBModel operation = operationRepository.save(operationDBModels.get(0));
            operationWSDTO.setOperation(operation);

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){

                List<InquiryDBModel> inquiryDBModels = inquiryRepository.findBySessionIdAndClientId(sessionId,clientId);
                inquiryDBModels.get(0).setInquiryState(AppConstant.ACTIVE_INQUIRY);
                inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                operationWSDTO.setOperationInquiry(inquiryRepository.save(inquiryDBModels.get(0)));
            }

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){

                List<FlowDBModel> flowDBModels = flowRepository.findBySessionIdAndClientId(sessionId,clientId);
                flowDBModels.get(0).setFlowState(AppConstant.ACTIVE_FLOW);
                flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                operationWSDTO.setOperationFlow(flowRepository.save(flowDBModels.get(0)));
            }

            activityHelper.createOperationActivity(operation.getSessionId(), operation.getId(), AppConstant.LAUNCH_OPERATION_ACTIVITY,
                    AppConstant.OPERATION_ACTIVITY, String.valueOf(operation.getAgentId()), AppConstant.USER_TYPE, operation.getId(), AppConstant.OPERATION_TYPE);

            return operationWSDTO;
        }
        return null;
    }


    public ApiOperationWSDTO apiFinishOperationService(long agentId, long sessionId, long clientId, String campaignId,String operationResult) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.READY_SESSION);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(sessionId, clientId, agentId, campaignId, AppConstant.READY_OPERATION);

        if (clientDBModel.isPresent() && clientDBModel.get().getClientState().equalsIgnoreCase(AppConstant.BUSY_CLIENT)
                && sessionDBModels.size() > 0 && operationDBModels.size()>0) {

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();

            clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            sessionDBModels.get(0).setSessionState(AppConstant.FINISHED_SESSION);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            operationWSDTO.setOperationSession(sessionRepository.save(sessionDBModels.get(0)));

            operationDBModels.get(0).setOperationResult(operationResult);
            operationDBModels.get(0).setOperationState(AppConstant.FINISHED_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            operationWSDTO.setOperation(operationRepository.save(operationDBModels.get(0)));

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){

                List<InquiryDBModel> inquiryDBModels = inquiryRepository.findBySessionIdAndClientId(sessionId,clientId);
                inquiryDBModels.get(0).setInquiryState(AppConstant.FINISHED_INQUIRY);
                inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                operationWSDTO.setOperationInquiry(inquiryRepository.save(inquiryDBModels.get(0)));
            }

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){

                List<FlowDBModel> flowDBModels = flowRepository.findBySessionIdAndClientId(sessionId,clientId);
                flowDBModels.get(0).setFlowState(AppConstant.FINISHED_FLOW);
                flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                operationWSDTO.setOperationFlow(flowRepository.save(flowDBModels.get(0)));
            }

            return operationWSDTO;
        }
        return null;
    }




    public ApiOperationWSDTO apiUpdateOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        return null;
    }



    public ApiOperationWSDTO apiRemoveOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignId(sessionId, clientId, agentId, campaignId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentId(sessionId, clientId, agentId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);


        return null;
    }


}
