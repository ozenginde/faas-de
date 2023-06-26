package com.faas.core.utils.mapper;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.session.details.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SipCallRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.operation.channel.WappCallRepository;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.temp.WappMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SessionMapper {


    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;



    public SessionDBModel mapSessionDBModel(CampaignDBModel campaignDBModel,UserDBModel agentDBModel ,ClientDBModel clientDBModel ) {

        SessionDBModel sessionDBModel = new SessionDBModel();

        sessionDBModel.setSessionUUID(appUtils.generateUUID());
        sessionDBModel.setClientId(clientDBModel.getId());
        sessionDBModel.setClientName(clientDBModel.getClientName());
        sessionDBModel.setNationalId(clientDBModel.getNationalId());
        sessionDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        sessionDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        sessionDBModel.setClientCity(clientDBModel.getClientCity());
        sessionDBModel.setClientCountry(clientDBModel.getClientCountry());
        sessionDBModel.setClientType(clientDBModel.getClientType());
        sessionDBModel.setCampaignId(campaignDBModel.getId());
        sessionDBModel.setCampaign(campaignDBModel.getCampaign());
        sessionDBModel.setCampaignType(campaignDBModel.getCampaignType());
        sessionDBModel.setProcessId(campaignDBModel.getProcessId());
        sessionDBModel.setProcess(campaignDBModel.getProcess());
        sessionDBModel.setProcessType(campaignDBModel.getProcessType());
        sessionDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        sessionDBModel.setAgentId(agentDBModel.getId());
        sessionDBModel.setAgentName(agentDBModel.getUserName());
        sessionDBModel.setSessionState(AppConstant.READY_SESSION);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setStatus(1);

        return sessionDBModel;
    }


    public PaginationWSDTO createSessionPaginationWSDTO(Page<SessionDBModel> sessionPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionPage.getTotalElements());

        return paginationWSDTO;
    }


    public List<ApiSummaryWSDTO> getApiSessionsSummary(long agentId){

        List<ApiSummaryWSDTO> sessionSummaries = new ArrayList<>();
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.TOTAL_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentId(agentId))));
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        sessionSummaries.add(new ApiSummaryWSDTO(AppConstant.COMPLETED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.COMPLETED_SESSION))));

        return sessionSummaries;
    }


    public ApiSessionDetailsWSDTO mapApiSessionDetailsWSDTO(SessionDBModel sessionDBModel){

        ApiSessionDetailsWSDTO sessionDetailsWSDTO = new ApiSessionDetailsWSDTO();
        sessionDetailsWSDTO.setSession(sessionDBModel);
        List<OperationDBModel> operationDBModels =operationRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        Optional<CampaignDBModel> campaignDBModel =campaignRepository.findById(sessionDBModel.getCampaignId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (operationDBModels.size()>0 && campaignDBModel.isPresent() && processDBModel.isPresent() ){
            sessionDetailsWSDTO.setOperation(operationDBModels.get(0));
            sessionDetailsWSDTO.setCampaign(campaignDBModel.get());
            sessionDetailsWSDTO.setProcess(processDBModel.get());
        }
        return sessionDetailsWSDTO;
    }




    public List<ApiSummaryWSDTO> mapSessionSummary(long agentId){

        List<ApiSummaryWSDTO> sessionSummary = new ArrayList<>();
        sessionSummary.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        sessionSummary.add(new ApiSummaryWSDTO(AppConstant.TOTAL_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentId(agentId))));
        sessionSummary.add(new ApiSummaryWSDTO(AppConstant.READY_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        sessionSummary.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        sessionSummary.add(new ApiSummaryWSDTO(AppConstant.COMPLETED_SESSIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.COMPLETED_SESSION))));

        return sessionSummary;
    }


}
