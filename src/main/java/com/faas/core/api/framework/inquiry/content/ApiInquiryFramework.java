package com.faas.core.api.framework.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class ApiInquiryFramework {

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    InquiryMapper inquiryMapper;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentInquiryWSDTO apiGetAgentInquiryService(long agentId,int reqPage,int reqSize){

        ApiAgentInquiryWSDTO agentInquiryWSDTO = new ApiAgentInquiryWSDTO();
        agentInquiryWSDTO.setReadyInquiry(inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,AppConstant.NEW_INQUIRY,PageRequest.of(reqPage,reqSize))));
        agentInquiryWSDTO.setActiveInquiry(inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,AppConstant.ACTIVE_INQUIRY,PageRequest.of(reqPage,reqSize))));
        return agentInquiryWSDTO;
    }


    public ApiInquiryWSDTO apiGetInquiriesService(long agentId, String inquiryState, int reqPage, int reqSize){

        return inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndInquiryState(agentId,inquiryState,PageRequest.of(reqPage,reqSize)));
    }


    public ApiInquiryWSDTO apiGetCampaignInquiriesService(long agentId, String campaignId,String inquiryState, int reqPage, int reqSize){

        return inquiryHelper.getApiInquiryWSDTO(inquiryRepository.findAllByAgentIdAndCampaignIdAndInquiryState(agentId,campaignId,inquiryState,PageRequest.of(reqPage,reqSize)));
    }



    public ApiInquiryWSDTO apiGetInquiryService(long agentId, long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }


    public ApiInquiryWSDTO apiUpdateInquiryService(long agentId, long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }


    public ApiInquiryWSDTO apiRemoveInquiryService(long agentId, long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }



}
