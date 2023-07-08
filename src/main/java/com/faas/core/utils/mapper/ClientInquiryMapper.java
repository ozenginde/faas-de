package com.faas.core.utils.mapper;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.inquiry.ClientInquiryDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.inquiry.dto.ClientInquiryWSDTO;
import com.faas.core.base.repo.inquiry.ClientInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientInquiryMapper {


    @Autowired
    ClientInquiryRepository clientInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ClientInquiryDBModel mapInquiryDBModel(CampaignDBModel campaignDBModel, ClientDBModel clientDBModel){

        ClientInquiryDBModel clientInquiryDBModel = new ClientInquiryDBModel();

        clientInquiryDBModel.setSessionId(0);
        clientInquiryDBModel.setSessionUUID("");
        clientInquiryDBModel.setClientId(clientDBModel.getId());
        clientInquiryDBModel.setClientName(clientDBModel.getClientName());
        clientInquiryDBModel.setNationalId(clientDBModel.getNationalId());
        clientInquiryDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        clientInquiryDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        clientInquiryDBModel.setClientCity(clientDBModel.getClientCity());
        clientInquiryDBModel.setClientCountry(clientDBModel.getClientCountry());
        clientInquiryDBModel.setClientType(clientDBModel.getClientType());
        clientInquiryDBModel.setCampaignId(campaignDBModel.getId());
        clientInquiryDBModel.setCampaign(campaignDBModel.getCampaign());
        clientInquiryDBModel.setCampaignType(campaignDBModel.getCampaignType());
        clientInquiryDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        clientInquiryDBModel.setProcessId(campaignDBModel.getProcessId());
        clientInquiryDBModel.setProcess(campaignDBModel.getProcess());
        clientInquiryDBModel.setProcessType(campaignDBModel.getProcessType());
        clientInquiryDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        clientInquiryDBModel.setAgentId(0);
        clientInquiryDBModel.setAgentName("");
        clientInquiryDBModel.setInquiryState(AppConstant.READY_INQUIRY);
        clientInquiryDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientInquiryDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientInquiryDBModel.setStatus(1);

        return clientInquiryDBModel;
    }


    public List<ClientInquiryWSDTO> createInquiryWSDTOS(List<ClientInquiryDBModel> clientInquiryDBModels){

        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();
        for (ClientInquiryDBModel clientInquiryDBModel : clientInquiryDBModels) {
            clientInquiryWSDTOS.add(new ClientInquiryWSDTO(clientInquiryDBModel));
        }
        return clientInquiryWSDTOS;
    }



    public PaginationWSDTO createClientInquiryPagination(Page<ClientInquiryDBModel> inquiryDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(inquiryDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(inquiryDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(inquiryDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(inquiryDBModelPage.getTotalElements());

        return paginationWSDTO;
    }



}
