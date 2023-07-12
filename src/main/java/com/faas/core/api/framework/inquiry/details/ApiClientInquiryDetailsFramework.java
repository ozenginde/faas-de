package com.faas.core.api.framework.inquiry.details;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.details.dto.ApiClientInquiryDetailsWSDTO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiClientInquiryDetailsFramework {



    public ApiClientInquiryDetailsWSDTO apiGetClientInquiryDetailsService(long agentId, long inquiryId){

        ApiClientInquiryDetailsWSDTO inquiryDetailsWSDTO = new ApiClientInquiryDetailsWSDTO();

        return inquiryDetailsWSDTO;
    }


    public List<ApiSummaryWSDTO> apiGetClientInquirySummaryService(long agentId){

        return null;
    }




}
