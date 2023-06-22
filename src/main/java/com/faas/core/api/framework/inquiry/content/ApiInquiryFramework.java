package com.faas.core.api.framework.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.db.inquiry.InquiryDBModel;
import com.faas.core.base.repo.inquiry.InquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiInquiryFramework {

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentInquiryWSDTO apiGetAgentInquiryService(long agentId){

        ApiAgentInquiryWSDTO agentInquiryWSDTO = new ApiAgentInquiryWSDTO();
        List<ApiInquiryWSDTO> readyInquiries = new ArrayList<>();
        List<ApiInquiryWSDTO> activeInquiries = new ArrayList<>();

        List<InquiryDBModel> readyInquiryDBModels =  inquiryRepository.findByAgentIdAndInquiryState(agentId, AppConstant.READY_INQUIRY);
        for (InquiryDBModel readyInquiryDBModel : readyInquiryDBModels) {
            readyInquiries.add(new ApiInquiryWSDTO(readyInquiryDBModel));
        }
        agentInquiryWSDTO.setReadyInquiries(readyInquiries);
        List<InquiryDBModel> activeInquiryDBModels =  inquiryRepository.findByAgentIdAndInquiryState(agentId, AppConstant.ACTIVE_INQUIRY);
        for (InquiryDBModel activeInquiryDBModel : activeInquiryDBModels) {
            activeInquiries.add(new ApiInquiryWSDTO(activeInquiryDBModel));
        }
        agentInquiryWSDTO.setActiveInquiries(activeInquiries);
        agentInquiryWSDTO.setInquirySummary(inquiryHelper.agentInquirySummaryHelper(agentId));

        return agentInquiryWSDTO;
    }


    public List<ApiInquiryWSDTO> apiGetInquiriesService(long agentId){

        return null;
    }


    public List<ApiInquiryWSDTO> apiGetInquiriesByStateService(long agentId, String inquiryState){

        return null;
    }


    public ApiInquiryWSDTO apiGetInquiryService(long agentId,long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }


    public ApiInquiryWSDTO apiUpdateInquiryService(long agentId,long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }


    public ApiInquiryWSDTO apiRemoveInquiryService(long agentId,long inquiryId){

        ApiInquiryWSDTO inquiryWSDTO = new ApiInquiryWSDTO();

        return inquiryWSDTO;
    }




}
