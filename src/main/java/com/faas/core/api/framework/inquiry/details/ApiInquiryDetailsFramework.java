package com.faas.core.api.framework.inquiry.details;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.details.dto.ApiInquiryDetailsWSDTO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiInquiryDetailsFramework {



    public ApiInquiryDetailsWSDTO apiGetInquiryDetailsService(long agentId, long inquiryId){

        ApiInquiryDetailsWSDTO inquiryDetailsWSDTO = new ApiInquiryDetailsWSDTO();

        return inquiryDetailsWSDTO;
    }


    public List<ApiSummaryWSDTO> apiGetAgentInquirySummaryService(long agentId){

        return null;
    }




}
