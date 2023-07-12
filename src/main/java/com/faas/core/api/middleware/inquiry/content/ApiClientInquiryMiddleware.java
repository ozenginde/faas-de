package com.faas.core.api.middleware.inquiry.content;

import com.faas.core.api.framework.inquiry.content.ApiClientInquiryFramework;
import com.faas.core.api.model.ws.inquiry.content.ApiAgentInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiClientInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiClientInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiClientInquiryMiddleware {


    @Autowired
    ApiClientInquiryFramework apiClientInquiryFramework;


    public ApiAgentInquiryWSModel apiGetAgentInquiry(long agentId) {

        ApiAgentInquiryWSModel response = new ApiAgentInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentInquiryWSDTO agentInquiryWSDTO = apiClientInquiryFramework.apiGetAgentInquiryService(agentId);
        if (agentInquiryWSDTO != null){
            response.setAgentInquiry(agentInquiryWSDTO);
        }

        general.setOperation("apiGetAgentInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientInquiryWSModel apiGetClientInquiries(long agentId) {

        ApiClientInquiryWSModel response = new ApiClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientInquiryWSDTO> clientInquiryWSDTOS = apiClientInquiryFramework.apiGetClientInquiriesService(agentId);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("apiGetClientInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientInquiryWSModel apiGetClientInquiriesByState(long agentId, String inquiryState) {

        ApiClientInquiryWSModel response = new ApiClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientInquiryWSDTO> clientInquiryWSDTOS = apiClientInquiryFramework.apiGetClientInquiriesByStateService(agentId,inquiryState);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("apiGetInquiriesByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientInquiryWSModel apiGetClientInquiry(long agentId, long inquiryId) {

        ApiClientInquiryWSModel response = new ApiClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientInquiryWSDTO>clientInquiryWSDTOS = new ArrayList<>();

        ApiClientInquiryWSDTO clientInquiryWSDTO = apiClientInquiryFramework.apiGetClientInquiryService(agentId,inquiryId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("apiGetClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientInquiryWSModel apiUpdateClientInquiry(long agentId, long inquiryId) {

        ApiClientInquiryWSModel response = new ApiClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientInquiryWSDTO>clientInquiryWSDTOS = new ArrayList<>();

        ApiClientInquiryWSDTO clientInquiryWSDTO = apiClientInquiryFramework.apiUpdateClientInquiryService(agentId,inquiryId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("apiUpdateClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientInquiryWSModel apiRemoveClientInquiry(long agentId, long inquiryId) {

        ApiClientInquiryWSModel response = new ApiClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientInquiryWSDTO>clientInquiryWSDTOS = new ArrayList<>();

        ApiClientInquiryWSDTO clientInquiryWSDTO = apiClientInquiryFramework.apiRemoveClientInquiryService(agentId,inquiryId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("apiRemoveClientInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
