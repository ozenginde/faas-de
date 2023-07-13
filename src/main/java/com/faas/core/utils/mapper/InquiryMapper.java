package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.inquiry.dto.InquiryWSDTO;
import com.faas.core.base.repo.inquiry.InquiryRepository;
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
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public InquiryDBModel mapInquiryDBModel(CampaignDBModel campaignDBModel, ClientDBModel clientDBModel){

        InquiryDBModel inquiryDBModel = new InquiryDBModel();

        inquiryDBModel.setSessionId(0);
        inquiryDBModel.setSessionUUID("");
        inquiryDBModel.setClientId(clientDBModel.getId());
        inquiryDBModel.setClientName(clientDBModel.getClientName());
        inquiryDBModel.setNationalId(clientDBModel.getNationalId());
        inquiryDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        inquiryDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        inquiryDBModel.setClientCity(clientDBModel.getClientCity());
        inquiryDBModel.setClientCountry(clientDBModel.getClientCountry());
        inquiryDBModel.setClientType(clientDBModel.getClientType());
        inquiryDBModel.setCampaignId(campaignDBModel.getId());
        inquiryDBModel.setCampaign(campaignDBModel.getCampaign());
        inquiryDBModel.setCampaignType(campaignDBModel.getCampaignType());
        inquiryDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        inquiryDBModel.setProcessId(campaignDBModel.getProcessId());
        inquiryDBModel.setProcess(campaignDBModel.getProcess());
        inquiryDBModel.setProcessType(campaignDBModel.getProcessType());
        inquiryDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        inquiryDBModel.setAgentId(0);
        inquiryDBModel.setAgentName("");
        inquiryDBModel.setInquiryState(AppConstant.READY_INQUIRY);
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



}
