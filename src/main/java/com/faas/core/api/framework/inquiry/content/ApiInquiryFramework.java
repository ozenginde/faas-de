package com.faas.core.api.framework.inquiry.content;

import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiCampaignInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
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
    AppUtils appUtils;


    public ApiAgentInquiryWSDTO apiGetAgentInquiryService(long agentId,int reqPage,int reqSize){

        ApiAgentInquiryWSDTO agentInquiryWSDTO = new ApiAgentInquiryWSDTO();
        List<ApiInquiryWSDTO> readyInquiries = new ArrayList<>();
        List<ApiInquiryWSDTO> activeInquiries = new ArrayList<>();



        return agentInquiryWSDTO;
    }


    public ApiCampaignInquiryWSDTO apiGetCampaignInquiryService(long agentId,String campaignId,int reqPage,int reqSize){

        ApiCampaignInquiryWSDTO campaignInquiryWSDTO = new ApiCampaignInquiryWSDTO();
        List<ApiInquiryWSDTO> readyInquiries = new ArrayList<>();
        List<ApiInquiryWSDTO> activeInquiries = new ArrayList<>();


        campaignInquiryWSDTO.setActiveInquiries(activeInquiries);

        return campaignInquiryWSDTO;
    }



    public ApiAgentInquiryWSDTO apiGetInquiriesService(long agentId,String inquiryState,int reqPage,int reqSize){

        ApiAgentInquiryWSDTO agentInquiryWSDTO = new ApiAgentInquiryWSDTO();
        List<ApiInquiryWSDTO> readyInquiries = new ArrayList<>();
        List<ApiInquiryWSDTO> activeInquiries = new ArrayList<>();


        agentInquiryWSDTO.setActiveInquiries(activeInquiries);

        return agentInquiryWSDTO;
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
