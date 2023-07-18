package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.inquiry.dto.InquiryWSDTO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InquiryMapper {


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public InquiryDBModel mapInquiryDBModel(SessionDBModel sessionDBModel){

        InquiryDBModel inquiryDBModel = new InquiryDBModel();

        inquiryDBModel.setSessionId(sessionDBModel.getId());
        inquiryDBModel.setClientId(sessionDBModel.getClientId());
        inquiryDBModel.setClientName(sessionDBModel.getClientName());
        inquiryDBModel.setPhoneNumber(sessionDBModel.getPhoneNumber());
        inquiryDBModel.setEmailAddress(sessionDBModel.getEmailAddress());
        inquiryDBModel.setClientCity(sessionDBModel.getClientCity());
        inquiryDBModel.setClientCountry(sessionDBModel.getClientCountry());
        inquiryDBModel.setCampaignId(sessionDBModel.getCampaignId());
        inquiryDBModel.setCampaign(sessionDBModel.getCampaign());
        inquiryDBModel.setProcessId(sessionDBModel.getProcessId());
        inquiryDBModel.setProcess(sessionDBModel.getProcess());
        inquiryDBModel.setAgentId(0);
        inquiryDBModel.setAgentName("");
        inquiryDBModel.setInquiryState(AppConstant.NEW_INQUIRY);
        inquiryDBModel.setuDate(appUtils.getCurrentTimeStamp());
        inquiryDBModel.setcDate(appUtils.getCurrentTimeStamp());
        inquiryDBModel.setStatus(1);

        return inquiryDBModel;
    }


    public List<InquiryWSDTO> createInquiryWSDTOS(List<InquiryDBModel> inquiryDBModels){

        List<InquiryWSDTO> inquiryWSDTOS = new ArrayList<>();
        for (InquiryDBModel inquiryDBModel : inquiryDBModels) {
            inquiryWSDTOS.add(new InquiryWSDTO(inquiryDBModel));
        }
        return inquiryWSDTOS;
    }



    public PaginationWSDTO createInquiryPagination(Page<InquiryDBModel> inquiryDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(inquiryDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(inquiryDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(inquiryDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(inquiryDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public PaginationWSDTO createAgentInquiryPagination(int pageSize,int pageNumber,int totalPage,long totalElements){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(pageSize);
        paginationWSDTO.setPageNumber(pageNumber);
        paginationWSDTO.setTotalPage(totalPage);
        paginationWSDTO.setTotalElements(totalElements);

        return paginationWSDTO;
    }


    public SessionDBModel mapInquirySession(CampaignDBModel campaignDBModel,ClientDBModel clientDBModel) {

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
        sessionDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        sessionDBModel.setProcessId(campaignDBModel.getProcessId());
        sessionDBModel.setProcess(campaignDBModel.getProcess());
        sessionDBModel.setProcessType(campaignDBModel.getProcessType());
        sessionDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        sessionDBModel.setAgentId(0);
        sessionDBModel.setAgentName("");
        sessionDBModel.setSessionType(campaignDBModel.getCampaignCategory());
        sessionDBModel.setSessionState(AppConstant.READY_SESSION);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setStatus(1);

        return sessionDBModel;
    }


    public OperationDBModel mapInquiryOperation(SessionDBModel sessionDBModel) {

        if (!operationRepository.existsBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId())){

            OperationDBModel operationDBModel = new OperationDBModel();
            operationDBModel.setSessionId(sessionDBModel.getId());
            operationDBModel.setSessionUUID(sessionDBModel.getSessionUUID());
            operationDBModel.setClientId(sessionDBModel.getClientId());
            operationDBModel.setAgentId(sessionDBModel.getAgentId());
            operationDBModel.setCampaignId(sessionDBModel.getCampaignId());
            operationDBModel.setProcessId(sessionDBModel.getProcessId());
            operationDBModel.setActivities(new ArrayList<>());
            operationDBModel.setOperationState(AppConstant.READY_OPERATION);
            operationDBModel.setOperationResult(AppConstant.RESULT_NONE);
            operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setStatus(1);

            return operationDBModel;
        }
        return null;
    }



}
