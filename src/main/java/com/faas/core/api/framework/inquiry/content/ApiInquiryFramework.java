package com.faas.core.api.framework.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiCampaignInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWrapper;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import com.faas.core.utils.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


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
        agentInquiryWSDTO.setReadyInquiry(getAgentReadyInquiries(agentId,reqPage,reqSize));
        agentInquiryWSDTO.setActiveInquiry(inquiryHelper.getApiInquiryWrapper(inquiryRepository.findAllByAgentIdAndInquiryState(agentId, AppConstant.ACTIVE_INQUIRY,PageRequest.of(reqPage,reqSize))));
        return agentInquiryWSDTO;
    }


    public ApiInquiryWrapper getAgentReadyInquiries(long agentId, int reqPage, int reqSize){

        ApiInquiryWrapper agentReadyInquiry = new ApiInquiryWrapper();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgentModels = campaignAgentRepository.findByAgentId(agentId);

        int k = 0;
        int totalPages = 0;
        long totalElements = 0;

        for (CampaignAgentDBModel campaignAgentModel : campaignAgentModels) {
            Page<InquiryDBModel> inquiryPages = inquiryRepository.findAllByCampaignIdAndInquiryState(campaignAgentModel.getCampaignId(), AppConstant.NEW_INQUIRY, PageRequest.of(reqPage, reqSize));
            totalPages = totalPages + inquiryPages.getTotalPages();
            totalElements = totalElements + inquiryPages.getTotalElements();
            for (int j = 0; j < inquiryPages.getContent().size(); j++) {
                if (k < reqSize) {
                    inquiryWSDTOS.add(inquiryHelper.getApiInquiryWSDTO(inquiryPages.getContent().get(j)));
                    k++;
                }
            }
        }
        agentReadyInquiry.setInquiries(inquiryWSDTOS);
        agentReadyInquiry.setPagination(inquiryMapper.createAgentInquiryPagination(reqSize,reqPage,totalPages,totalElements));

        return agentReadyInquiry;
    }



    public ApiCampaignInquiryWSDTO apiGetCampaignInquiryService(long agentId, String campaignId, String inquiryState, int reqPage, int reqSize){

        ApiCampaignInquiryWSDTO campaignInquiryWSDTO = new ApiCampaignInquiryWSDTO();
        campaignInquiryWSDTO.setReadyInquiry(inquiryHelper.getApiInquiryWrapper(inquiryRepository.findAllByAgentIdAndInquiryState(agentId, AppConstant.READY_INQUIRY,PageRequest.of(reqPage,reqSize))));
        campaignInquiryWSDTO.setActiveInquiry(inquiryHelper.getApiInquiryWrapper(inquiryRepository.findAllByAgentIdAndInquiryState(agentId, AppConstant.ACTIVE_INQUIRY,PageRequest.of(reqPage,reqSize))));

        return campaignInquiryWSDTO;
    }


    public ApiInquiryWSDTO apiGetInquiriesService(long agentId,String inquiryState,int reqPage,int reqSize){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
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
