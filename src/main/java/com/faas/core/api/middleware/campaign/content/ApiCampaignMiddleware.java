package com.faas.core.api.middleware.campaign.content;

import com.faas.core.api.framework.campaign.content.ApiCampaignFramework;
import com.faas.core.api.model.ws.campaign.content.ApiAgentCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignMiddleware {

    @Autowired
    ApiCampaignFramework apiCampaignFramework;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentCampaignWSModel apiGetAgentCampaign(long agentId) {

        ApiAgentCampaignWSModel response = new ApiAgentCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentCampaignWSDTO agentCampaignWSDTO = apiCampaignFramework.apiGetAgentCampaignService(agentId);
        if (agentCampaignWSDTO != null){
            response.setAgentCampaign(agentCampaignWSDTO);
        }

        general.setOperation("apiGetAgentCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetCampaigns(long agentId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> apiCampaignWSDTOS = apiCampaignFramework.apiGetCampaignsService(agentId);
        if (apiCampaignWSDTOS != null){
            response.setCampaigns(apiCampaignWSDTOS);
        }

        general.setOperation("apiGetCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetCampaignsByState(long agentId,String campaignState) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> campaignWSDTOS = apiCampaignFramework.apiGetCampaignsByStateService(agentId,campaignState);
        if (campaignWSDTOS != null){
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("apiGetCampaignsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetCampaignsByCategory(long agentId, String campaignCategory) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> campaignWSDTOS = apiCampaignFramework.apiGetCampaignsByCategoryService(agentId,campaignCategory);
        if (campaignWSDTOS != null){
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("apiGetCampaignsByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetCampaign(long agentId,String campaignId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        ApiCampaignWSDTO campaignWSDTO = apiCampaignFramework.getApiCampaignService(campaignId);
        if (campaignWSDTO != null){
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getApiCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
