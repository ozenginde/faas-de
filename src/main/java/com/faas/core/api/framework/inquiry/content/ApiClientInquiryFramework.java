package com.faas.core.api.framework.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiClientInquiryWSDTO;

import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiClientInquiryFramework {

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    AppUtils appUtils;


    public ApiAgentInquiryWSDTO apiGetAgentInquiryService(long agentId){

        ApiAgentInquiryWSDTO agentInquiryWSDTO = new ApiAgentInquiryWSDTO();
        List<ApiClientInquiryWSDTO> readyInquiries = new ArrayList<>();
        List<ApiClientInquiryWSDTO> activeInquiries = new ArrayList<>();


        agentInquiryWSDTO.setActiveInquiries(activeInquiries);
        agentInquiryWSDTO.setClientInquirySummary(inquiryHelper.agentInquirySummaryHelper(agentId));

        return agentInquiryWSDTO;
    }


    public List<ApiClientInquiryWSDTO> apiGetClientInquiriesService(long agentId){

        return null;
    }


    public List<ApiClientInquiryWSDTO> apiGetClientInquiriesByStateService(long agentId, String inquiryState){

        return null;
    }


    public ApiClientInquiryWSDTO apiGetClientInquiryService(long agentId, long inquiryId){

        ApiClientInquiryWSDTO clientInquiryWSDTO = new ApiClientInquiryWSDTO();

        return clientInquiryWSDTO;
    }


    public ApiClientInquiryWSDTO apiUpdateClientInquiryService(long agentId, long inquiryId){

        ApiClientInquiryWSDTO clientInquiryWSDTO = new ApiClientInquiryWSDTO();

        return clientInquiryWSDTO;
    }


    public ApiClientInquiryWSDTO apiRemoveClientInquiryService(long agentId, long inquiryId){

        ApiClientInquiryWSDTO clientInquiryWSDTO = new ApiClientInquiryWSDTO();

        return clientInquiryWSDTO;
    }




}
