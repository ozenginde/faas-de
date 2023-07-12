package com.faas.core.api.middleware.inquiry.details;

import com.faas.core.api.framework.inquiry.details.ApiClientInquiryDetailsFramework;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.details.ApiClientInquiryDetailsWSModel;
import com.faas.core.api.model.ws.inquiry.details.dto.ApiClientInquiryDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiClientInquiryDetailsMiddleware {


    @Autowired
    ApiClientInquiryDetailsFramework apiClientInquiryDetailsFramework;


    public ApiClientInquiryDetailsWSModel apiGetClientInquiryDetails(long agentId, long inquiryId) {

        ApiClientInquiryDetailsWSModel response = new ApiClientInquiryDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiClientInquiryDetailsWSDTO clientInquiryDetailsWSDTO  = apiClientInquiryDetailsFramework.apiGetClientInquiryDetailsService(agentId,inquiryId);
        if (clientInquiryDetailsWSDTO != null){
            response.setClientInquiryDetails(clientInquiryDetailsWSDTO);
        }

        general.setOperation("apiGetClientInquiryDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiSummaryWSModel apiGetClientInquirySummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> inquirySummaries  = apiClientInquiryDetailsFramework.apiGetClientInquirySummaryService(agentId);
        if (inquirySummaries != null){
            response.setSummaries(inquirySummaries);
        }

        general.setOperation("apiGetClientInquirySummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
