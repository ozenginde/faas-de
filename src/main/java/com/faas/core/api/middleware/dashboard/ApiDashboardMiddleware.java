package com.faas.core.api.middleware.dashboard;

import com.faas.core.api.framework.dashboard.ApiDashboardFramework;
import com.faas.core.api.model.ws.dashboard.ApiDashCampaignWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashSummaryWSModel;
import com.faas.core.api.model.ws.dashboard.ApiDashboardWSModel;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashCampaignWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashSummaryWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.api.model.ws.inquiry.content.ApiInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.content.ApiSessionWSModel;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiDashboardMiddleware {


    @Autowired
    ApiDashboardFramework apiDashboardFramework;


    public ApiDashboardWSModel apiGetDashboard(long agentId,int reqPage,int reqSize) {

        ApiDashboardWSModel response = new ApiDashboardWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiDashboardWSDTO dashboardWSDTO = apiDashboardFramework.apiGetDashboardService(agentId,reqPage,reqSize);
        if (dashboardWSDTO != null){
            response.setDashboard(dashboardWSDTO);
        }

        general.setOperation("apiGetDashboard");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSessionWSModel apiGetDashSession(long agentId,String sessionState,int reqPage,int reqSize) {

        ApiSessionWSModel response = new ApiSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSessionWSDTO sessionWSDTO = apiDashboardFramework.apiGetDashSessionService(agentId,sessionState,reqPage,reqSize);
        if (sessionWSDTO != null){
            response.setSession(sessionWSDTO);
        }

        general.setOperation("apiGetDashSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiGetDashInquiry(long agentId, String inquiryState, int reqPage, int reqSize) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiDashboardFramework.apiGetDashInquiryService(agentId,inquiryState,reqPage,reqSize);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiGetDashInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiDashCampaignWSModel apiGetDashCampaign(long agentId) {

        ApiDashCampaignWSModel response = new ApiDashCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiDashCampaignWSDTO> dashCampaignWSDTOS = apiDashboardFramework.apiGetDashCampaignService(agentId);
        if (dashCampaignWSDTOS != null){
            response.setDashCampaigns(dashCampaignWSDTOS);
        }

        general.setOperation("apiGetDashCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiDashSummaryWSModel apiGetDashSummary(long agentId) {

        ApiDashSummaryWSModel response = new ApiDashSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiDashSummaryWSDTO> dashSummaries = apiDashboardFramework.apiGetDashSummaryService(agentId);
        if (dashSummaries != null){
            response.setDashSummaries(dashSummaries);
        }

        general.setOperation("apiGetDashSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
